package y2022.m5.day01;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import javax.xml.ws.Action;

/**
 * @Author: leah_ana
 * @Date: 2022/5/1 23:36
 */
@SpringBootTest
public class Test {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

}
