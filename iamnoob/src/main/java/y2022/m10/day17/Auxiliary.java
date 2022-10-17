package y2022.m10.day17;

import sun.awt.windows.ThemeReader;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @Author: LeahAna
 * @Date: 2022/10/17 09:08
 * @Desc: JUC三大辅助类
 */

public class Auxiliary {
    // 减少计数
    private CountDownLatch countDownLatch;

    // 循环栅栏
    private CyclicBarrier cyclicBarrier;

    // 信号灯
    private Semaphore semaphore;


    // CountDownLatch类可以设置一个计数器，通过countDown方法来进行-1的操作，
    // 使用await方法等待计数器不大于0。然后继续执行await方法之后的语句
    // 注意点：
    // 1.CountDownLatch主要有方法，当一个或多个线程调用await方法时，这个线程会阻塞
    // 2.其他线程调用countDown 方法时会将计数器-1（调用countDown档发的线程不会阻塞）
    // 3.当计数器的值变为0时，因await方法阻塞的线程会被唤醒，继续执行

    //场景： 6个同学陆续离开教室后 值班的同学才可以关门
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <=6; i++) {
            new Thread(()->{
                try {
                    if (Thread.currentThread().getName().equals("同学6")){
                        Thread.sleep(2000);
                    }
                    System.out.println(Thread.currentThread().getName()+"离开了");
                // 计数器减1，不会阻塞
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            },"同学"+i).start();
        }

        // 主线程await休息
        System.out.println("主线程在睡觉");
        countDownLatch.await();
        // 全部离开后自动唤醒主线程
        System.out.println("全部离开了，现在计数器为："+countDownLatch.getCount());
    }

}
