package y2023.m5.day09.poet;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 类属性注解，反射用
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EColumn {

    /**
     * 例：
     * @EClolum("标识")
     * private String characteristic;
     */
    String value();
}
