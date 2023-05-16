package top.yannyi.autobase.core.aspect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: LeahAna
 * @Date: 2023/4/4 09:08
 * @Desc: 方法处理时间计算注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogMethodExecutionTime {
}
