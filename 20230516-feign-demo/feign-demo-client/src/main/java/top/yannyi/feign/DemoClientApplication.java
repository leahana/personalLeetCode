package top.yannyi.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: LeahAna
 * @Date: 2023/5/16 10:40
 * @Desc:
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class DemoClientApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoClientApplication.class, args);

    }

}
