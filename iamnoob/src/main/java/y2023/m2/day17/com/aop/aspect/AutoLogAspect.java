package y2023.m2.day17.com.aop.aspect;

import cn.hutool.core.date.DateUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: LeahAna
 * @Date: 2023/2/17 10:01
 * @Desc: 切面
 */


@Aspect
@Component
public class AutoLogAspect {

    @Pointcut(" @annotation(y2023.m2.day17.com.aop.annotation.AutoLog)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        String now = DateUtil.now();
        System.out.println(now + "+around");

        return point.proceed();
    }


}
