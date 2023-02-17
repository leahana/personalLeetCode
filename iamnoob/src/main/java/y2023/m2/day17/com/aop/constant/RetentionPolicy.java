package y2023.m2.day17.com.aop.constant;

/**
 * @Author: LeahAna
 * @Date: 2023/2/17 09:50
 * @Desc: 元注解
 */
public enum RetentionPolicy {
    SOURCE, // 编译器处理完Annotation后 不储存在class中
    CLASS,  // 编译器把Annotation储存在class中，这是默认值
    RUNTIME     //  储存在class中 可以被虚拟机读取，反射需要
}
