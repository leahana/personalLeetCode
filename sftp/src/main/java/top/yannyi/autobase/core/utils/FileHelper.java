package top.yannyi.autobase.core.utils;

import cn.hutool.core.util.RandomUtil;
import com.jcraft.jsch.ChannelSftp;
import lombok.extern.slf4j.Slf4j;
import top.yannyi.autobase.core.aspect.annotation.ParamCheck;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @Author: LeahAna
 * @Date: 2023/4/6 16:31
 * @Desc:
 */

@Slf4j
public class FileHelper {

    private static final String UNDERSCORE = "_";

    /**
     * 递归读取路径下所有文件的文件名
     *
     * @param path 路径
     * @return 文件名列表
     */
    public static List<String> getAllFileNames(String path) {
        List<String> fileNames = new ArrayList<>();
        File file = new File(path);
        if (file.isDirectory()) {
            // 如果是目录，递归获取所有文件名
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    fileNames.addAll(getAllFileNames(subFile.getAbsolutePath()));
                }
            }
        } else if (file.isFile()) {
            // 如果是文件，获取文件名
            fileNames.add(file.getName());
        }
        return fileNames;
    }

    @ParamCheck
    public static boolean backupFileToDirectory(String source, String target) {
        boolean flag = true;
        try {
            Path sourcePath = Paths.get(source);
            String timestamp = String.valueOf(Instant.now().toEpochMilli());
            // 备份文件的唯一标识符
            // 时间戳_10以内随机数_文件名
            Path backupFilePath = Paths.get
                    (target,
                            timestamp + UNDERSCORE
                                    + RandomUtil.randomNumbers(1) + UNDERSCORE
                                    + sourcePath.getFileName().toString());
            Files.copy(sourcePath, backupFilePath, StandardCopyOption.REPLACE_EXISTING);
            log.info("File copied successfully! backupFilePath={}", backupFilePath);
        } catch (IOException ex) {
            flag = false;
            log.error("IoException:", ex);
        }
        return flag;
    }


    @ParamCheck
    public static String joinPath(String path, String filename) {
        return path.endsWith(File.separator) ? path + filename : path + File.separator + filename;
    }

    @ParamCheck
    public static void filterFilenames(String endWith, List<String> fileList, Vector dirs) {
        for (Object dir : dirs) {
            String fileFullName = ((ChannelSftp.LsEntry) dir).getFilename();
            String[] filenameArr = fileFullName.split("\\.");
            if (filenameArr.length > 1) {
                if (endWith.equalsIgnoreCase(filenameArr[filenameArr.length - 1])) {
                    fileList.add(fileFullName);
                }
            }
        }
    }

    /**
     * 创建本地路径
     *
     * @param path
     */
    @ParamCheck
    public static void mkDirs(String path) throws IOException {
        File file = new File(path);
        if (file.isDirectory()) {
            log.info("Directory already exists at {}", path);
            return;
        }

        if (file.mkdirs()) {
            log.info("Directory created at {}", path);
        } else {
            File parent = file.getParentFile();
            if (parent.mkdirs() && file.mkdirs()) {
                log.info("Directory created at {}", path);
            } else {
                throw new IOException("Failed to create directory at " + path);
            }
        }
    }

}
