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
    private String ip;
    private Integer port;
    private String username;
    private String password;
    private Integer timeOut;

}
