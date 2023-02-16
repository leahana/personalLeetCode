package y2023.m2.day16;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import y2022.m11.day14.SimpleDateFormatTest;
import y2023.m2.day16.com.mpdemo.MybatisPlusDemoApplication;
import y2023.m2.day16.com.mpdemo.mapper.MpDemoMapper;
import y2023.m2.day16.com.mpdemo.model.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Author: LeahAna
 * @Date: 2023/2/16 09:49
 * @Desc:
 */
@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest(classes = MybatisPlusDemoApplication.class)
public class SqlTest {

    @Autowired
    private MpDemoMapper mapper;

    @Test
    public void testInsert() throws InterruptedException {


        Date date = new Date();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setEmail(i + "@Gmail.com");
            user.setPassword(i + "pswd");

            Date newDate = DateUtil.offset(date, DateField.DAY_OF_MONTH, -i);

            user.setStartTime(DateUtil.formatDateTime(newDate));
            mapper.insert(user);
            Thread.sleep(10000);
        }
    }

    @Test
    public void testDelete() {

        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<User> le = lqw.gt(User::getId, 37);
        mapper.delete(le);
//
//        eq 就是 equal等于
//        ne就是 not equal不等于
//        gt 就是 greater than大于
//        lt 就是 less than小于
//        ge 就是 greater than or equal 大于等于
//        le 就是 less than or equal 小于等于
//        in 就是 in 包含（数组）
//        isNull 就是 等于null
//        between 就是 在2个条件之间(包括边界值)
//        like 就是 模糊查询

    }


    @Test
    public void testSearch() {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.ge(User::getStartTime, "2023-02-15 11:01:36");
        List<User> users = mapper.selectList(lqw);

        users.forEach(user -> log.info("{}", user));


    }


}
