package y2022.m5.day01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: leah_ana
 * @Date: 2022/5/1 23:36
 */
@SpringBootApplication
@Slf4j
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
        log.info("TestApplication start success ！ ！ ！");
    }
}
