package y2023.m2.day17.com.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: LeahAna
 * @Date: 2023/2/17 10:11
 * @Desc:
 */

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopLogsDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(AopLogsDemoApplication.class, args);
    }
}
