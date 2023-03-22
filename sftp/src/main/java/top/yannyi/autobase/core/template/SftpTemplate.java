package top.yannyi.autobase.core.template;

import cn.hutool.Hutool;
import cn.hutool.core.util.ObjectUtil;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import top.yannyi.autobase.core.properties.SftpProperties;

import javax.swing.JFileChooser;
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
public class SftpTemplate {

    private final SftpProperties sftpProperties;
    private ChannelSftp channelSftp = new ChannelSftp();
    private Session session = null;
    private Channel channel = null;


    public SftpTemplate(SftpProperties sftpProperties) {
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
            if (ObjectUtil.isNotNull(this.channel)) {
                this.channel.disconnect();
                log.info("关闭sftp操作对象channel成功");
            }
            if (ObjectUtil.isNotNull(this.session)) {
                this.session.disconnect();
                log.info("sftp关闭session 成功");
            }
            log.info("关闭sftp操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("关闭sftp操作失败");
            flag = false;
        }
        return flag;
    }


    /**
     * 获取文件夹内文件名
     *
     * @param path    文件夹路径
     * @param endWith 文件后缀 如"txt"
     * @return 文件名（包括后缀）
     */
    public List<String> getFileNames(String path, String endWith) {
        List<String> fileList = new ArrayList<>();
        try {
            Vector dirs = this.channelSftp.ls(path);
            for (Object dir : dirs) {
                String fileFullName = ((ChannelSftp.LsEntry) dir).getFilename();
                String[] filenameArr = fileFullName.split("\\.");
                if (filenameArr.length > 1) {
                    if (endWith.equalsIgnoreCase(filenameArr[filenameArr.length - 1])) {
                        fileList.add(fileFullName);
                    }
                }
            }
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
        FileInputStream fis = null;
        try {
            channelSftp.cd(filepath);
            fis = new FileInputStream(localPath + File.separator + filename);
            channelSftp.put(fis,filename);
            log.info("文件{}上传成功，filePath={},localPath={}", filename, filepath, localPath);
        } catch (SftpException | FileNotFoundException e) {
            e.printStackTrace();
            log.error("文件{}上传失败，filePath={},localPath={}", filename, filepath, localPath);
            flag = false;
        } finally {
            try {
                Objects.requireNonNull(fis).close();
            } catch (IOException e) {
                e.printStackTrace();
                flag = false;
            }

        }
        return flag;
    }


    /**
     * sftp删除文件
     *
     * @param filepath 文件夹路径
     * @param filename 文件名
     * @return 是否删除成功
     */
    public boolean delete(final String filepath, final String filename) {
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


    public boolean downloadFile(final String filepath, final String filename, final String localPath) {
        boolean flag = true;
        FileOutputStream fos = null;
        try {
            channelSftp.cd(filepath);
            String downloadFinalFilepath = filepath + File.separator + filename;
            String localFilepath = localPath + File.separator + filename;
            fos = new FileOutputStream(localFilepath);
            channelSftp.get(filename, fos);
            log.info("文件：{} 下载成功，本地文件位置：{}", downloadFinalFilepath, localFilepath);
        } catch (SftpException | FileNotFoundException e) {
            flag = false;
            e.printStackTrace();
            log.error("文件下载失败 filename={},filepath={}", filename, filepath);
        } finally {
            try {
                Objects.requireNonNull(fos).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
