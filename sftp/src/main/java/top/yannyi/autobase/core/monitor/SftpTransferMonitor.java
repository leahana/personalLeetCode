package top.yannyi.autobase.core.monitor;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpProgressMonitor;
import lombok.extern.slf4j.Slf4j;


/**
 * @Author: LeahAna
 * @Date: 2023/4/3 09:22
 * @Desc: 监控文件上传下载管理
 */

@Slf4j
public class SftpTransferMonitor implements SftpProgressMonitor {

    private long transferred;
    private long fileSize;
    private String src;
    private String dest;
    private ChannelSftp channelSftp;
    private String filename;

    public SftpTransferMonitor(String src,String dest, String filename,ChannelSftp channelSftp) {
        this.src = src;
        this.dest = dest;
        this.channelSftp=channelSftp;
        this.filename=filename;
    }

    /**
     * @param op：传输操作类型，即put或get。
     * @param src：源文件路径，即本地文件路径或远程文件路径。
     * @param dest：目标文件路径，即远程文件路径或本地文件路径。
     * @param max：传输文件的总大小。
     */
    @Override
    public void init(int op, String src, String dest, long max) {
        log.info("Starting transfer " + src + " to " + dest + " with size " + max + " bytes");
        fileSize = max;
    }

    @Override
    public boolean count(long count) {
        transferred += count;
        // 每传输1MB就打印一次进度
        if (transferred % (1024 * 1024) == 0) {
            log.info("transferred " + transferred + " bytes, " + getProgress() + "%");
        }
        return true;
    }

    @Override
    public void end() {
        // 文件传输成功回调函数
        log.info("Finished file transfer: " + src);
    }

    private int getProgress() {
        return (int) (transferred * 100 / fileSize);
    }

    public long getTransferred() {
        return transferred;
    }

    public void setTransferred(long transferred) {
        this.transferred = transferred;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

}
