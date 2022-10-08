package y2022.m10.day08;

import java.util.concurrent.locks.Lock;

/**
 * @Author: LeahAna
 * @Date: 2022/10/8 09:14
 * @Desc:
 */

public class Test {
// Thread.State
    // NEW  新建
    // RUNNABLE 准备就绪
    // BLOCKED 阻塞
    // WAITING 等待
    // TIMED_WAITING 超时
    // TERMINATED 终结

    //wait和sleep的区别
    // 1.sleep是Thread的静态方法，wait是Object方法，任何对象实例都能调用
    // 2.sleep不会释放锁，也不需要占用锁， wait 会释放所，但调用他的前提是当前线程占有锁（
    //   代码在synchronized中
    // 3.都可以被interrupted方法中断

    // Lock 与 synchronized 区别
    // 1.synchronized是java关键字 内置特性，Lock不是java内置的。Lock是一个类，通过这个类可
    //   可以实现同步访问

    // 2.Lock需要手动释放，synchronized不需要手动释放。



}
