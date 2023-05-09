package y2023.m5.day09.poet;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 解析类注解中文名，对应 交互场景数据标签
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ETable {

    String value();


    // 没有使用
    Class<?> tableClass();
}
