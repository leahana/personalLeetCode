package y2022.m10.day14;

import java.util.concurrent.TimeUnit;

/**
 * @Author: LeahAna
 * @Date: 2022/10/14 09:14
 * @Desc: 多线程锁
 */

public class Phone {

    // 信息
    public static synchronized void sendSMS() throws Exception {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("------sendSMS");
    }

    // 邮件
    public synchronized void sendEmail() throws Exception {

        System.out.println("-----sendEmail");

    }

    public void getHello() {
        System.out.println("------getHello");
    }

    // 1.标准访问， 先短信还是先邮件
    // ------sendSMS
    // ------sendEmail
    // 一个对象里面多个synchronized方法，某一时刻内，只要一个线程去调用其中的synchronized方法
    // 其他的线程都只能等待，某一时刻内，只能有唯一 一个线程去访问这些synchronized
    // 锁的对想是档前对象this被锁定后 其他的线程都不能进入到当前对象的其她synchronized方法中
    // 加个普通方法后 同步锁与普通方法无关，
    // 换成两个对象后 不是同一把锁，情况改变，synchronized 实现同步的基础：java中的每一个对象
    // 都能可以作为锁

    // 具体三种形式
    // 对于普通同步方法 ，锁是当前实力对象
    // 对于静态同步方法， 锁是当前类的Class对象
    // 对于同步方法块，锁是synchronized括号里面配置的对象

}
