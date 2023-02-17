package y2023.m2.day17.com.aop.annotation;

import y2023.m2.day17.com.aop.constant.CommonConstant;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: LeahAna
 * @Date: 2023/2/17 09:54
 * @Desc:
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoLog {

    /**
     * 日志内容
     * @return
     */
    String value() default "";


    /**
     *  日志类型
     *
     */

    int logType() default CommonConstant.LOG_TYPE_2;


    /**
     * 操作日志类型
     *
     * @return （1查询，2添加，3修改，4删除）
     */
    int operateType() default 0;

}
