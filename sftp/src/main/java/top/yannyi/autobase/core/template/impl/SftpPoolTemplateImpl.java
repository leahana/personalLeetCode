package top.yannyi.autobase.core.template.impl;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import top.yannyi.autobase.core.exception.ErrorResult;
import top.yannyi.autobase.core.exception.SftpRetryException;
import top.yannyi.autobase.core.factory.SftpConnectionPool;
import top.yannyi.autobase.core.properties.SftpProperties;
import top.yannyi.autobase.core.template.SftpTemplate;
import top.yannyi.autobase.core.utils.FileHelper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @Author: LeahAna
 * @Date: 2023/4/4 12:32
 * @Desc: 使用连接池的 sftp操作模版
 */

@Slf4j
public class SftpPoolTemplateImpl implements SftpTemplate {

    /**
     * SFTP连接相关配置信息
     */
    private final SftpProperties sftpProperties;


    /**
     * SFTP连接池
     */
    private final SftpConnectionPool pool;


    /**
     * 构造方法，初始化SFTP连接池和SFTP连接相关配置信息
     *
     * @param pool           SFTP连接池
     * @param sftpProperties SFTP连接相关配置信息
     */
    public SftpPoolTemplateImpl(SftpConnectionPool pool, SftpProperties sftpProperties) {
        this.pool = pool;
        this.sftpProperties = sftpProperties;
    }


    /**
     * 从连接池中获取一个可用的SFTP连接通道
     *
     * @return ChannelSftp对象
     * @throws RuntimeException 连接池获取连接异常
     */
    private ChannelSftp getChannelSftp() {
        try {
            return pool.borrowConnection();
        } catch (Exception e) {
            throw new RuntimeException("sftpConnectPool borrowConnection failed");
        }
    }


    /**
     * 将使用完毕的SFTP连接通道归还到连接池中
     *
     * @param channelSftp 使用完毕的ChannelSftp对象
     */
    private void returnChannelSftp(ChannelSftp channelSftp) {
        try {
            pool.returnConnection(channelSftp);
        } catch (Exception e) {
            throw new RuntimeException("sftpConnectPool returnConnection failed");
        }
    }


    @Override
    public String getHome() throws SftpException {
        ChannelSftp channelSftp = getChannelSftp();
        try {
            return channelSftp.getHome();
        } finally {
            returnChannelSftp(channelSftp);
        }
    }


    @Override
    public List<String> getLs(final String path) throws SftpException {
        ChannelSftp channelSftp = getChannelSftp();
        List<String> list = new ArrayList<>();
        Vector ls;
        try {
            ls = channelSftp.ls(path);
            for (Object dir : ls) {
                String fileFullName = ((ChannelSftp.LsEntry) dir).getFilename();
                list.add(fileFullName);
            }
            return list;
        } finally {
            returnChannelSftp(channelSftp);
        }
    }


    @Override
    public List<String> getFilenames(final String path) throws SftpException {
        ChannelSftp channelSftp = getChannelSftp();
        try {
            List<String> fileList = new ArrayList<>();
            Vector dirs = channelSftp.ls(path);
            for (Object dir : dirs) {
                String fileFullName = ((ChannelSftp.LsEntry) dir).getFilename();
                String[] filenameArr = fileFullName.split("\\.");
                if (filenameArr.length > 1) {
                    fileList.add(fileFullName);
                }
            }
            return fileList;
        } finally {
            returnChannelSftp(channelSftp);
        }
    }


    @Override
    public List<String> getFilenames(final String path, final String endWith) throws SftpException {
        ChannelSftp channelSftp = getChannelSftp();
        try {
            List<String> fileList = new ArrayList<>();
            Vector dirs = channelSftp.ls(path);
            FileHelper.filterFilenames(endWith, fileList, dirs);
            return fileList;
        } finally {
            returnChannelSftp(channelSftp);
        }

    }


    @Override
    public String downloadFile(final String filename) throws SftpRetryException {
        return downloadFileWithRetry(filename);
    }


    private String downloadFileWithRetry(String filename) throws SftpRetryException {
        int retryCount = 0;
        boolean success = false;
        // 下载完成后的本地路径
        String fullFilename = FileHelper.joinPath(sftpProperties.getLocalTmpPath(), filename);
        while (!success && retryCount <= sftpProperties.getMaxRetries()) {
            try {
                downloadFileWithRetryInternal(fullFilename, filename, null);
                success = true;
                log.info("File {} download from SFTP server successfully .", filename);
            } catch (SftpException e) {
                retryCount++;
                log.error("Failed to download file {} to SFTP server. Retrying in {} milliseconds. Error message: "
                        , filename, sftpProperties.getRetryInterval(), e);
                sleep(sftpProperties.getRetryInterval());
            } catch (IOException e) {
                log.error("Failed to read file {} from {}. Error message: "
                        , filename, sftpProperties.getDownloadPath(), e);
                throw new SftpRetryException(ErrorResult.downloadError());
            }
        }
        if (!success) {
            throw new SftpRetryException(ErrorResult.downloadError());
        }
        return fullFilename;
    }


    private void downloadFileWithRetryInternal(String fullFilename, String filename, String filePath) throws IOException, SftpException {
        ChannelSftp channelSftp = getChannelSftp();
        try (FileOutputStream fos = new FileOutputStream(fullFilename)) {
            channelSftp.cd(StringUtils.isNotEmpty(filePath) ? filePath : sftpProperties.getDownloadPath());
            channelSftp.get(filename, fos);
            log.info("File {} download from SFTP server successfully .", filename);
        } finally {
            returnChannelSftp(channelSftp);
        }
    }


    @Override
    public boolean downloadFile(final String filepath, final String filename, final String localPath) {
        boolean flag = true;
        String fullFilename = FileHelper.joinPath(localPath, filename);
        try {
            downloadFileWithRetryInternal(fullFilename, filename, filepath);
        } catch (SftpException e) {
            flag = false;
            log.error("Failed to download filename={},filepath={} from SFTP server. Error Message:",
                    filename, sftpProperties.getDownloadPath(), e);
        } catch (IOException e) {
            log.error("Failed to writer {}. Error Message:", fullFilename, e);
        }
        return flag;
    }


    @Override
    public boolean deleteFile(final String filepath, final String filename) {
        boolean flag = true;
        ChannelSftp channelSftp = getChannelSftp();
        String finalPathname = FileHelper.joinPath(filepath, filename);
        try {
            try {
                channelSftp.rm(finalPathname);
                log.info("deleteFile 文件删除成功 filepath={},filename={}", filepath, filename);
            } catch (SftpException e) {
                flag = false;
                log.error("deleteFile 文件删除失败 filepath={},filename={}", filepath, filename, e);
            }
            return flag;
        } finally {
            returnChannelSftp(channelSftp);
        }
    }


    @Override
    public void deleteFile(final String filename) throws SftpRetryException {
        deleteFileWithRetry(filename);
    }


    private void deleteFileWithRetry(String filename) throws SftpRetryException {
        int retryCount = 0;
        boolean success = false;
        while (!success && retryCount <= sftpProperties.getMaxRetries()) {
            try {
                deleteFileWithRetryInternal(filename);
                success = true;
            } catch (SftpException e) {
                retryCount++;
                log.error("Failed to delete file {} " +
                                "from SFTP server. Retrying in {} " +
                                "milliseconds. Error message: ",
                        filename, sftpProperties.getRetryInterval(), e);
                sleep(sftpProperties.getRetryInterval());
            }
            if (!success) {
                throw new SftpRetryException(ErrorResult.deleteError());
            }
        }
    }


    private void deleteFileWithRetryInternal(String filename) throws SftpException {
        ChannelSftp channelSftp = getChannelSftp();
        try {
            channelSftp.cd(sftpProperties.getDownloadPath());
            channelSftp.rm(filename);
        } finally {
            returnChannelSftp(channelSftp);
        }
    }


    @Override
    public boolean uploadFile(final String filepath, final String filename, final String localPath) {
        boolean flag = true;
        String fullFilePath = FileHelper.joinPath(localPath, filename);
        try {
            uploadFileWithRetryInternal(fullFilePath, filename, filepath);
        } catch (SftpException e) {
            log.error("Failed to upload file {} to SFTP server", filename, e);
            flag = false;
        } catch (IOException ioException) {
            log.error("Failed to read file {}", filename, ioException);
        }
        return flag;
    }


    @Override
    public void uploadFile(final String filename) throws SftpRetryException {
        uploadFileWithRetry(filename);
    }


    private void uploadFileWithRetry(String filename) throws SftpRetryException {
        int retryCount = 0;
        boolean success = false;
        String fullFilename = FileHelper.joinPath(sftpProperties.getLocalTmpPath(), filename);
        while (!success && retryCount <= sftpProperties.getMaxRetries()) {
            try {
                uploadFileWithRetryInternal(fullFilename, filename, null);
                success = true;
                log.info("File {} uploaded successfully to SFTP server.", filename);
            } catch (SftpException e) {
                retryCount++;
                log.error("Failed to upload file {} " +
                                "to SFTP server. Retrying in {} " +
                                "milliseconds. Error message: ",
                        filename, sftpProperties.getRetryInterval(), e);
                sleep(sftpProperties.getRetryInterval());
            } catch (IOException e) {
                log.error("Failed to read file{}, IOException: ", fullFilename, e);
                throw new SftpRetryException(ErrorResult.uploadError());
            }
        }
        if (!success) {
            throw new SftpRetryException(ErrorResult.uploadError());
        }
    }


    private void uploadFileWithRetryInternal(String fullFilename, String filename, String filePath) throws SftpException, IOException {
        ChannelSftp channelSftp = getChannelSftp();
        try (FileInputStream fis = new FileInputStream(fullFilename)) {
            channelSftp.cd(StringUtils.isNotEmpty(filePath) ? filePath : sftpProperties.getUploadPath());
            channelSftp.put(fis, filename);
        } finally {
            returnChannelSftp(channelSftp);
        }
    }


    /**
     * 重试等待
     *
     * @param milliseconds 等待时间
     */
    private void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ignore) {
        }
    }


    @Override
    public boolean createDir(final String createPath) {
        ChannelSftp channelSftp = getChannelSftp();
        try {
            channelSftp.mkdir(createPath);
            return true;
        } catch (SftpException e) {
            e.printStackTrace();
            return false;
        } finally {
            returnChannelSftp(channelSftp);
        }
    }


    @Override
    public boolean isDirExist(final String directory) {
        ChannelSftp channelSftp = getChannelSftp();
        try {
            SftpATTRS sftpATTRS = channelSftp.stat(directory);
            return sftpATTRS.isDir();
        } catch (SftpException e) {
            log.error("isDirExist throws SftpException :", e);
            return false;
        } finally {
            returnChannelSftp(channelSftp);
        }
    }


    @Override
    public boolean deleteDir(final String path, final String remoteDirectory) {
        ChannelSftp channelSftp = getChannelSftp();
        try {
            channelSftp.cd(path);
            Vector lsResult = channelSftp.ls(remoteDirectory);
            for (Object obj : lsResult) {
                if (obj instanceof ChannelSftp.LsEntry) {
                    String filename = ((ChannelSftp.LsEntry) obj).getFilename();
                    // 过滤掉.和..文件
                    if (!".".equals(filename) && !"..".equals(filename)) {
                        SftpATTRS attrs = ((ChannelSftp.LsEntry) obj).getAttrs();
                        if (attrs.isDir()) {
                            deleteDir(path + "/" + remoteDirectory, filename);
                        } else {
                            channelSftp.rm(path + "/" + remoteDirectory + "/" + filename);
                        }
                    }
                }
            }
            channelSftp.rmdir(path + "/" + remoteDirectory);
            return true;
        } catch (SftpException e) {
            e.printStackTrace();
            return false;
        } finally {
            returnChannelSftp(channelSftp);
        }
    }


    @Override
    public boolean close() {
        pool.shutdown();
        return true;
    }
}
