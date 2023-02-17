package y2023.m2.day17.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import y2023.m2.day17.com.aop.AopLogsDemoApplication;
import y2023.m2.day17.com.aop.service.DemoService;

/**
 * @Author: LeahAna
 * @Date: 2023/2/17 10:33
 * @Desc:
 */
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest(classes = AopLogsDemoApplication.class)
public class AopLogsTest {
    @Autowired
    private DemoService demoService;
    @Test
    public void test(){
        demoService.print();
    }

}
