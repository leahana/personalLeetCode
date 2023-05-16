package top.yannyi.autobase.core.template;

import com.jcraft.jsch.SftpException;
import top.yannyi.autobase.core.exception.SftpRetryException;

import java.util.List;


/**
 * @Author: LeahAna
 * @Date: 2023/4/4 15:42
 * @Desc: sftp操作模版接口
 */
public interface SftpTemplate {

    /**
     * 查看sftp根目录
     *
     * @return 根目录
     */
    String getHome() throws SftpException;


    /**
     * 查看路径文件
     *
     * @param path 路径
     * @return 文件夹名和文件名 list
     */
    List<String> getLs(String path) throws SftpException;


    /**
     * 获取文件夹内文件名
     *
     * @param path 文件夹路径
     * @return 文件名（包括后缀）
     */
    List<String> getFilenames(String path) throws SftpException;


    /**
     * 获取文件夹内文件名
     *
     * @param path    文件夹路径
     * @param endWith 文件后缀 如"txt"
     * @return 文件名（包括后缀）
     */
    List<String> getFilenames(String path, String endWith) throws SftpException;


    /**
     * sftp上传文件到服务器
     *
     * @param filepath  上传文件路径
     * @param filename  文件名
     * @param localPath 本地路径
     * @return 文件上传是否成功
     */
    boolean uploadFile(final String filepath, final String filename, final String localPath);


    /**
     * sftp上传文件到服务器
     * @param filename 文件名
     * @throws SftpRetryException 重试失败异常
     */
    void uploadFile(final String filename) throws SftpRetryException;


    /**
     * sftp删除文件
     *
     * @param filepath 文件夹路径
     * @param filename 文件名
     * @return 是否删除成功
     */
    boolean deleteFile(final String filepath, final String filename);


    /**
     * sftp下载文件到本地
     *
     * @param filepath  文件路径
     * @param filename  文件名
     * @param localPath 本地路径
     * @return 是否下载成功
     */
    boolean downloadFile(final String filepath, final String filename, final String localPath);


    /**
     * 创建文件夹路径
     *
     * @param createPath 创建路径
     * @return 是否创建成功
     */
    boolean createDir(String createPath);


    /**
     * 判断是否sftp路径是否存在
     *
     * @param directory 文件路径
     * @return 是否存在
     */
    boolean isDirExist(String directory);


    /**
     * 删除文件夹
     *
     * @param path            文件夹路径
     * @param remoteDirectory 文件夹名称
     * @return 是否删除成功
     */
    boolean deleteDir(String path, String remoteDirectory);


    /**
     * 下载SFTP服务器上的文件。
     *
     * @param filename 要下载的文件名。
     * @return 下载到本地的文件路径。
     */
    String downloadFile(String filename) throws SftpRetryException;


    /**
     * 删除SFTP服务器上的文件。
     *
     * @param filename 要删除的文件名。
     */
    void deleteFile(String filename) throws SftpRetryException;


    // 下面三个default方法在使用connectPool时不用手动实现
    /**
     * 打开SFTP连接。
     *
     * @return 是否成功打开连接。
     */
    default boolean open() {
        return false;
    }

    /**
     * 关闭SFTP连接。
     *
     * @return 是否成功关闭连接
     */
    default boolean close() {
        return false;
    }

    /**
     * 判断当前是否连接到SFTP服务器。
     *
     * @return 是否连接到SFTP服务器。
     */
    default boolean isConnect() {
        return false;
    }


}
