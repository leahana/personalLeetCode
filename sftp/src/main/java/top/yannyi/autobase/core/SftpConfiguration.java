package top.yannyi.autobase.core;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import top.yannyi.autobase.core.properties.SftpProperties;
import top.yannyi.autobase.core.template.SftpTemplate;

/**
 * @Author: LeahAna
 * @Date: 2023/3/22 14:32
 * @Desc: Sftp自动注入配置类
 */
@EnableConfigurationProperties({SftpProperties.class})
public class SftpConfiguration {


    @Bean
    public SftpTemplate sftpTemplate(SftpProperties sftpProperties) {
        return new SftpTemplate(sftpProperties);
    }
}
