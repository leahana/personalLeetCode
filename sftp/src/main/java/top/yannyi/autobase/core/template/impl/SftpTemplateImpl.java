package top.yannyi.autobase.core.template.impl;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import top.yannyi.autobase.core.listen.SftpFileListener;
import top.yannyi.autobase.core.monitor.SftpTransferMonitor;
import top.yannyi.autobase.core.properties.SftpProperties;
import top.yannyi.autobase.core.template.SftpTemplate;
import top.yannyi.autobase.core.utils.FileHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Vector;

/**
 * @Author: LeahAna
 * @Date: 2023/3/22 14:06
 * @Desc: sftp操作模版类
 */

@Slf4j
public class SftpTemplateImpl implements SftpTemplate {

    private final SftpProperties sftpProperties;
    private ChannelSftp channelSftp = new ChannelSftp();
    private Session session = null;
    private Channel channel = null;


    public SftpTemplateImpl(SftpProperties sftpProperties) {
        this.sftpProperties = sftpProperties;
    }

    /**
     * 打开sftp连接
     *
     * @return 连接是否成功
     */
    public boolean open() {
        String username = sftpProperties.getUsername();
        String password = sftpProperties.getPassword();
        String ip = sftpProperties.getIp();
        int port = sftpProperties.getPort();
        int timeOut = sftpProperties.getTimeOut();
        return getChannel(ip, port, username, password, timeOut);
    }


    private boolean getChannel(String ip, int port, String username, String password, int timeOut) {
        boolean flag = true;
        try {
            JSch jSch = new JSch();
            this.session = jSch.getSession(username, ip, port);
            if (StringUtils.isNotEmpty(password)) {
                this.session.setPassword(password);
                log.info("登陆密码已设置");
            }
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            this.session.setConfig(config);
            this.session.setTimeout(timeOut);
            this.session.connect();
            this.channel = this.session.openChannel("sftp");
            this.channel.connect();
            log.info("登陆sftp服务器成功{}", ip + ":" + port);
            this.channelSftp = (ChannelSftp) this.channel;
        } catch (JSchException e) {
            e.printStackTrace();
            log.error("登陆sftp服务器失败{}", ip + ":" + port);
            flag = false;
        }
        return flag;
    }

    /**
     * 关闭sftp连接
     *
     * @return 连接是否成功
     */
    public boolean close() {
        boolean flag = true;
        try {
            if (this.channel != null) {
                this.channel.disconnect();
            }
            if (this.session != null) {
                this.session.disconnect();
            }
        } catch (Exception e) {
            log.error("关闭sftp连接失败", e);
            flag = false;
        } finally {
            if (this.channel != null && !this.channel.isClosed()) {
                log.warn("sftp操作对象channel未被关闭");
            }
            if (this.session != null && this.session.isConnected()) {
                log.warn("sftp连接session未被关闭");
            }
            log.info("关闭sftp操作");
        }
        return flag;
    }

    @Override
    public List<String> getFilenames(String path) throws SftpException {
        channelSftp.cd(path);
        Vector dirs = channelSftp.ls(path);
        List<String> fileList = new ArrayList<>();
        for (Object dir : dirs) {
            String fileFullName = ((ChannelSftp.LsEntry) dir).getFilename();
            String[] filenameArr = fileFullName.split("\\.");
            if (filenameArr.length > 1) {
                fileList.add(fileFullName);
            }
        }
        return fileList;
    }


    /**
     * 获取文件夹内文件名
     *
     * @param path    文件夹路径
     * @param endWith 文件后缀 如"txt"
     * @return 文件名（包括后缀）
     */
    public List<String> getFilenames(String path, String endWith) {
        List<String> fileList = new ArrayList<>();
        try {
            Vector dirs = this.channelSftp.ls(path);
            FileHelper.filterFilenames(endWith, fileList, dirs);
        } catch (SftpException e) {
            e.printStackTrace();
            log.error("sftp获取目录下文件，文件后缀为：{}集合失败 path={},", endWith, path);
        }
        return fileList;
    }

    /**
     * sftp上传文件到服务器
     *
     * @param filepath  上传文件路径
     * @param filename  文件名
     * @param localPath 本地路径
     * @return 文件上传是否成功
     */
    public boolean uploadFile(String filepath, String filename, String localPath) {
        boolean flag = true;
        String fullFilePath = localPath + File.separator + filename;
        try (FileInputStream fis = new FileInputStream(fullFilePath);) {
            channelSftp.cd(filepath);
            channelSftp.put(fis, filename);
            log.info("文件{}上传成功，filePath={},localPath={}", filename, filepath, localPath);
        } catch (SftpException | FileNotFoundException e) {
            e.printStackTrace();
            log.error("文件{}上传失败，filePath={},localPath={}", filename, filepath, localPath);
            flag = false;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public void uploadFile(String filename) {
    }


    /**
     * sftp删除文件
     *
     * @param filepath 文件夹路径
     * @param filename 文件名
     * @return 是否删除成功
     */
    public boolean deleteFile(final String filepath, final String filename) {
        boolean flag = true;
        String finalPathname = filepath + File.separator + filename;
        try {
            channelSftp.rm(finalPathname);
            log.info("文件删除成功 filepath={},filename={}", filepath, filename);
        } catch (SftpException e) {
            flag = false;
            e.printStackTrace();
            log.error("文件删除失败 filepath={},filename={}", filepath, filename);
        }
        return flag;
    }


    /**
     * sftp下载文件到本地
     *
     * @param filepath  文件路径
     * @param filename  文件名
     * @param localPath 本地路径
     * @return 是否下载成功
     */
    public boolean downloadFile(final String filepath, final String filename, final String localPath) {
        boolean flag = true;
        String downloadFinalFilepath = filepath + File.separator + filename;
        String localFilepath = localPath + File.separator + filename;
        try (FileOutputStream fos = new FileOutputStream(localFilepath)) {
            channelSftp.cd(filepath);
            channelSftp.get(filename, fos);
            log.info("文件：{} 下载成功，本地文件位置：{}", downloadFinalFilepath, localFilepath);
        } catch (SftpException | FileNotFoundException e) {
            flag = false;
            e.printStackTrace();
            log.error("文件下载失败 filename={},filepath={}", filename, filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return flag;
    }

    /**
     * 创建文件夹路径
     *
     * @param createPath 创建路径
     * @return 是否创建成功
     */
    public boolean createDir(String createPath) {
        createPath = StringUtils.isNotEmpty(createPath) && createPath.endsWith("/")
                ? createPath : createPath + ("/");
        boolean flag = true;
        if (!isDirExist(createPath)) {
            StringBuilder builder = new StringBuilder("/");
            String[] pathArr = createPath.split("/");
            for (String dir : pathArr) {
                if (!Objects.equals("", dir)) {
                    builder.append(dir);
                    builder.append("/");
                    String path = "";
                    try {
                        path = builder.toString();
                        if (!isDirExist(path)) {
                            // 建立目录
                            channelSftp.mkdir(path);
                        } else {
                            log.info("文件夹已存在无需创建");
                        }

                    } catch (SftpException e) {
                        log.error("文件夹：{}创建失败", path);
                        flag = false;
                    }
                }
            }
        }
        return flag;
    }

    /**
     * 判断是否sftp路径是否存在
     *
     * @param directory 文件路径
     * @return 是否存在
     */
    public boolean isDirExist(String directory) {
        directory = StringUtils.isNotEmpty(directory) && directory.endsWith("/")
                ? directory : directory + "/";
        boolean flag = false;
        try {
            SftpATTRS lstat = channelSftp.lstat(directory);
            flag = lstat.isDir();
            log.info("路径文件夹已存在，directory={}", directory);
        } catch (Exception e) {
            log.info("路径文件夹不存在，directory={}", directory);
        }

        return flag;

    }

    /**
     * 查看sftp根目录
     *
     * @return 根目录
     */
    public String getHome() {
        String home = "";
        try {
            home = channelSftp.getHome();
        } catch (SftpException e) {
            log.error("getHome获取根目录失败,{}", e.getMessage());
        }
        return home;
    }

    /**
     * 查看路径文件
     *
     * @param path 路径
     * @return 文件夹名和文件名 list
     */
    public List<String> getLs(final String path) {
        List<String> list = new ArrayList<>();
        Vector ls = null;
        try {
            ls = channelSftp.ls(path);
            for (Object dir : ls) {
                String fileFullName = ((ChannelSftp.LsEntry) dir).getFilename();
                list.add(fileFullName);
            }
        } catch (SftpException e) {
            log.error("ls 获取文件名失败,{}", e.getMessage());
        }
        return list;
    }

    /**
     * 删除文件夹
     *
     * @param path            文件夹路径
     * @param remoteDirectory 文件夹名称
     * @return 是否删除成功
     */
    public boolean deleteDir(final String path, final String remoteDirectory) {
        boolean flag = true;
        String finalPathname = FileHelper.joinPath(path, remoteDirectory);
        try {
            channelSftp.rm(finalPathname);
            log.info("文件夹删除成功 path={},remoteDirectory={}", path, remoteDirectory);
        } catch (SftpException e) {
            flag = false;
            log.error("文件夹删除失败 path={},remoteDirectory={},{}", path, remoteDirectory, e.getMessage());
        }
        return flag;
    }

    public void getLsWithSelector(String path, SftpFileListener sftpFileListener) throws SftpException {
        channelSftp.ls(path, sftpFileListener);
    }

    public String downloadFile(String filename) {
        String localPath = sftpProperties.getLocalTmpPath();
        String localFullPath = localPath + File.separator + filename;
        try (FileOutputStream fos = new FileOutputStream(localFullPath)) {
            channelSftp.cd(sftpProperties.getDownloadPath());
            channelSftp.get(filename, fos);
            log.info("文件filename={}下载成功", filename);
        } catch (SftpException | FileNotFoundException e) {
            log.error("文件下载失败 filename={},{}", filename, e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return localFullPath;
    }

    public boolean putFile(String localFile, String remoteDir, String filename) {

        try {
            channelSftp.put(
                    localFile,
                    remoteDir,
                    new SftpTransferMonitor(
                            localFile,
                            remoteDir,
                            filename,
                            this.channelSftp));

        } catch (SftpException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void deleteFile(String filename) {
    }

    public void addChannelSftpEventListener() {
    }

    public boolean isConnect() {
        return channelSftp.isConnected();
    }


    public SftpProperties getSftpProperties() {
        return sftpProperties;
    }

    public ChannelSftp getChannelSftp() {
        return channelSftp;
    }

    public void setChannelSftp(ChannelSftp channelSftp) {
        this.channelSftp = channelSftp;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

}
