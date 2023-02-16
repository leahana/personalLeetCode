package y2023.m2.day16.com.mpdemo;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

/**
 * @Author: LeahAna
 * @Date: 2023/2/16 09:46
 * @Desc: mybatis plus 复习
 */

@SpringBootApplication
@Slf4j
@MapperScan("y2023.m2.day16.com.mpdemo.mapper")
public class MybatisPlusDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusDemoApplication.class, args);
        log.info("MybatisPlusDemoApplication  start success ！！！");
    }
}
