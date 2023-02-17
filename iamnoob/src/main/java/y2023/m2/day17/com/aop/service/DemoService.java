package y2023.m2.day17.com.aop.service;

import org.springframework.stereotype.Service;
import y2023.m2.day17.com.aop.annotation.AutoLog;
import y2023.m2.day17.com.aop.constant.CommonConstant;

/**
 * @Author: LeahAna
 * @Date: 2023/2/17 10:24
 * @Desc:
 */

@Service
public class DemoService {
    @AutoLog(value = "sss", logType = CommonConstant.LOG_TYPE_2, operateType = 2)
    public void print() {
        System.err.println("DemoService  print");
    }
}
