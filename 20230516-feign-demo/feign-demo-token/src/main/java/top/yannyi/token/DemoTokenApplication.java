package top.yannyi.token;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author: LeahAna
 * @Date: 2023/5/16 14:30
 * @Desc:
 */

@SpringBootApplication
@EnableDiscoveryClient
public class DemoTokenApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoTokenApplication.class, args);
    }
}
