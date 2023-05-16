package top.yannyi.autobase.core.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.Arrays;
import java.util.Objects;

/**
 * @Author: LeahAna
 * @Date: 2023/4/4 09:09
 * @Desc: 切面
 */


@Slf4j
@Aspect
public class LoggingAspect {
    public LoggingAspect() {
        log.info("LoggingAspect init success");
    }
    /**
     * 记录 top.yannyi.autobase.core.template 包中所有类的所有方法的入参和返回值
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* top.yannyi.autobase.core.template.impl.*.*(..))")
    public Object logClass(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getName();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();
        String[] parameterNames = methodSignature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        log.debug("Class.Method= {}.{}() is called with parameterNames: {} ,args: {} ", className, methodName, parameterNames, args);
        Object result = joinPoint.proceed();
        log.debug("Class.Method= {}.{}() returns: {}", className, methodName, result);
        return result;
    }


    /**
     * 记录方法处理时间
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("@annotation(top.yannyi.autobase.core.aspect.annotation.LogMethodExecutionTime)")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.debug("Class.Method= {}.{}() execution time: {}ms", className, methodName, endTime - startTime);
        return result;

    }

    /**
     * 参数校验
     *
     * @param joinpoint
     */
    @Before("@annotation(top.yannyi.autobase.core.aspect.annotation.ParamCheck)")
    public void paramCheck(JoinPoint joinpoint) {
        Object[] args = joinpoint.getArgs();
        if (containsNullOrEmpty(args)) {
            throw new RuntimeException("Argument cannot be null or empty");
        }

    }

    private boolean containsNullOrEmpty(Object[] args) {
        return Arrays.stream(args).allMatch(
                value -> Objects.isNull(value) ||
                        String.valueOf(value).trim().isEmpty());
    }


}
