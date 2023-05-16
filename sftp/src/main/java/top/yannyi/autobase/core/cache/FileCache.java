package top.yannyi.autobase.core.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalCause;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.jcraft.jsch.SftpException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import top.yannyi.autobase.core.exception.SftpRetryException;
import top.yannyi.autobase.core.properties.SftpProperties;
import top.yannyi.autobase.core.template.SftpTemplate;
import top.yannyi.autobase.core.template.impl.EFileTemplate;
import top.yannyi.autobase.core.utils.FileHelper;

import javax.annotation.Nonnull;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * @Author: LeahAna
 * @Date: 2023/4/3 14:29
 * @Desc: 文件缓存
 */
@Slf4j
public class FileCache {

    private final BlockingQueue<String> fileQueue;

    private final LoadingCache<String, File> fileCache;

    private final ConcurrentHashMap<String, String> configCache;

    private final SftpTemplate sftpTemplate;

    private final SftpProperties sftpProperties;

    private final EFileTemplate eFileTemplate;

    private final Executor fileDownloadThreadPool;


    private final ReadWriteLock cacheLock = new ReentrantReadWriteLock();

    // 读锁
    private final Lock readLock = cacheLock.readLock();

    // 写锁
    private final Lock writeLock = cacheLock.writeLock();


    /**
     * 构造方法，通过自动装配获取 SftpTemplate、SftpProperties、EFileTemplate 和文件下载线程池等实例，
     * 以及通过 @Value 注解获取一些配置参数，最终构建一个文件缓存实例。
     *
     * @param sftpTemplate           SFTP 操作模板
     * @param sftpProperties         SFTP 配置属性
     * @param eFileTemplate          EFile 操作模板
     * @param fileDownloadThreadPool 文件下载线程池
     * @param maximumSize            缓存最大容量
     * @param expireTimeMinutes      缓存过期时间（分钟）
     * @param cacheFolder            缓存文件夹路径
     */

    public FileCache(SftpTemplate sftpTemplate,
                     SftpProperties sftpProperties,
                     EFileTemplate eFileTemplate,
                     BlockingQueue<String> fileQueue,
                     Executor fileDownloadThreadPool,
                     int maximumSize,
                     int expireTimeMinutes,
                     String cacheFolder) {
        // 将自动装配的实例赋值给成员变量
        this.sftpProperties = sftpProperties;
        this.sftpTemplate = sftpTemplate;
        this.eFileTemplate = eFileTemplate;
        this.fileDownloadThreadPool = fileDownloadThreadPool;
        this.fileQueue = fileQueue;
        fileCache = CacheBuilder.newBuilder()
                .maximumSize(maximumSize)
                .expireAfterAccess(expireTimeMinutes, TimeUnit.MINUTES)// 缓存一小时
                .removalListener((RemovalListener<String, File>) notification -> {
                            RemovalCause cause = notification.getCause();
                            switch (cause) {
                                case EXPLICIT:
                                    // 缓存条目被显式移除
                                    log.debug("Cache removed: {}", notification.getKey());
                                    handleExplicitRemoval(notification);
                                    break;
                                case EXPIRED:
                                    // 处理过期缓存的逻辑
                                    log.debug("Cache expired: {}", notification.getKey());
                                    break;
                                case SIZE:
                                    // 处理缓存回收的逻辑
                                    log.debug("Cache evicted: {}", notification.getKey());
                                    break;
                                default:
                                    // 其他原因删除缓存操作：
                                    log.error("Cache remove with other case={}", cause);
                                    break;
                            }
                        }
                ).build(new CacheLoader<String, File>() {
                    //如果缓存中没有命中，则会自动调用CacheLoader的load方法进行加载。
                    @Override
                    public File load(@Nonnull String filename) throws Exception {
                        String filePath = sftpTemplate.downloadFile(filename);
                        log.info("fileCache 暂无{}", filename);
                        return eFileTemplate.readFile(filePath);
                    }
                });

        configCache = new ConcurrentHashMap<>();
        // 设置缓存文件夹路径
        cacheFolder(cacheFolder);

        log.info("FileCache init success ");
    }

    // 缓存被显式删除调用
    private void handleExplicitRemoval(RemovalNotification<String, File> notification) {
        File file = notification.getValue();
        if (Objects.nonNull(file) && file.exists()) {
            log.info("delete file :{}", file);
            boolean isBakSuccess = FileHelper.backupFileToDirectory(file.getPath(), sftpProperties.getDownloadBakPath());
            if (isBakSuccess) {
                boolean localDelete = file.delete();
                log.debug("localDelete:{} ", localDelete);
//                fileDownloadThreadPool.execute(() -> {
                try {
                    sftpTemplate.deleteFile(file.getName());
                } catch (SftpRetryException e) {
                    log.error("SftpRetryException:", e);
                }
                log.debug("sftp delete success ");
//                });
            }
        }
    }


    public File getFileByName(String filename) throws ExecutionException {
        return fileCache.get(filename);
    }


    /**
     * 定时任务调用缓存加载or下载
     */
    public void loadFiles() throws InterruptedException, SftpException {
        List<String> sftpFilenames = getSftpFilenames();
        addFileQueen(sftpFilenames);
        while (!fileQueue.isEmpty()) {
            String filename = fileQueue.take();
            fileDownloadThreadPool.execute(() -> {
                try {
                    String filePath = sftpTemplate.downloadFile(filename);
                    File file = eFileTemplate.readFile(filePath);
                    fileCache.put(filename, file);
                } catch (Exception e) {
                    log.error("loadFiles Exception: {}", e.toString());
                    // 异常发生时重新将任务放回队列中
                    addFileQueen(Collections.singletonList(filename));
                }
            });
        }
    }

    public List<String> getSftpFilenames() throws SftpException {
        return sftpTemplate.getFilenames(sftpProperties.getDownloadPath());
    }

    // 从缓存中清除文件
    public void invalidate(String filename) {
        fileCache.invalidate(filename);
        log.info("invalidate filename={} from fileCache", filename);
    }


    // 把要下载的文件放入阻塞队列
    public void addFileQueen(String filename) {
        if (Objects.isNull(fileCache.getIfPresent(filename)) && !fileQueue.contains(filename)) {
            boolean offer = fileQueue.offer(filename);
            log.info("filename={} offer to fileQueue result={}", filename, offer);
        }
    }

    public void addFileQueen(List<String> filenames) {
        for (String filename : filenames) {
            // 缓存和队列都没有就添加到队列
            if (Objects.isNull(fileCache.getIfPresent(filename))
                    && !fileQueue.contains(filename)) {
                boolean offer = fileQueue.offer(filename);
                log.info("filename={} offer to fileQueue result={}", filename, offer);
            } else {
                log.info("Filename:{} isExist", filename);
            }
        }
    }


    // 从缓存中获取文件 如果没有就下载文件
    private File getFileFromCacheOrDownload(String filename) throws InterruptedException {
        // 先尝试从缓存中获取文件
        File file = fileCache.getIfPresent(filename);
        if (Objects.nonNull(file)) {
            return file;
        }
        // 等待文件下载完成并被缓存后返回
        return waitForDownload(filename);
    }


    private File waitForDownload(String filename) throws InterruptedException {
        File file;
        long wait = 1000;
        do {
            // 从缓存中查找文件
            file = fileCache.getIfPresent(filename);
            if (Objects.nonNull(file)) {
                return file;
            }
            // 如果缓存中不存在该文件，等待一段时间后再次尝试查找
            Thread.sleep(++wait);
        } while (wait < 1005);
        return null;
    }


    /**
     * 获取配置
     *
     * @param configName 配置名称
     * @return 配置内容
     */
    public String getConfig(String configName) {
        return configCache.get(configName);
    }

    /**
     * 设置配置
     *
     * @param configName    配置名称
     * @param configContext 配置内容
     */
    public void setConfig(String configName, String configContext) {
        if (StringUtils.isNotEmpty(configName) && StringUtils.isNotEmpty(configContext)) {
            configCache.put(configName, configContext);
        }
    }

    /**
     * 缓存文件夹下所有文件的内容到配置缓存中
     *
     * @param folderPath 文件夹路径
     */
    private void cacheFolder(String folderPath) {
        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            cacheFilesInFolder(folder);
        }
    }

    /**
     * 缓存文件夹下的所有文件的内容到配置缓存中
     *
     * @param folder 文件夹对象
     */
    private void cacheFilesInFolder(File folder) {
        File[] files = folder.listFiles();
        if (Objects.nonNull(files)) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // 递归遍历子文件夹
                    cacheFilesInFolder(file);
                } else {
                    // 将文件存入缓存
                    String filePath = file.getAbsolutePath();
                    configCache.put(filePath, eFileTemplate.readFileContext(filePath));
                }
            }
        }
    }
}


