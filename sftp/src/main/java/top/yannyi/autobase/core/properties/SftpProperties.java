package top.yannyi.autobase.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: LeahAna
 * @Date: 2023/3/22 14:17
 * @Desc: Sftp配置注入
 */

@Data
@ConfigurationProperties("auto-template-base.sftp")
public class SftpProperties {

    /**
     * 下载路径 sftp服务器文件目标文件夹所在路径
     */
    private String downloadPath;
    /**
     * 上传路径 sftp服务器的上传文件目的地
     */
    private String uploadPath;
    /**
     * 本地路径 /下载/上传临时文件夹
     */
    private String localTmpPath;
    /**
     * 下载文件备份路径
     */
    private String downloadBakPath;
    /**
     * 上传文件备份路径
     */
    private String uploadBakPath;

    /**
     * 配置文件所在路径
     */
    private String configPath;

    /**
     * 重试次数
     */
    private Integer maxRetries;
    /**
     * 重试等待时间
     */
    private Long retryInterval;

    private Integer timeOut;
    private String ip;
    private Integer port = 22;
    // 两次空闲连接检查之间的时间间隔。如果为负数，则表示不进行周期性检查。
    private Integer timeBetweenEvictionRunsMillis = 8000;
    // SFTP服务器用户名
    private String username;
    // SFTP服务器密码
    private String password;
    // SFTP服务器秘钥文件路径
    private String privateKey;
    // SFTP服务器秘钥密码
    private String passphrase;
    // 连接池最大连接数
    private int maxTotal = 5;
    private int maxIdle = 1;
    private int minIdle = 0;
    // 每个路由最大连接数
    private int maxPerRoute = 2;
    // 连接超时时间
    private int connectTimeout = 10000;
    // 读取超时时间
    private int readTimeout = 10000;
    // SFTP服务器端口号
    // testOnBorrow：从连接池中获取连接时，是否进行有效性检查。如果为 true，每次从连接池中获取连接时，都会调用 validateObject 方法检查连接是否有效。如果连接无效，将会被销毁并从连接池中移除。这可以避免获取到已经失效的连接
    private Boolean testOnBorrow = true;
    //连接池空闲时，是否进行有效性检查。
    private Boolean testWhileIdle = true;
}
