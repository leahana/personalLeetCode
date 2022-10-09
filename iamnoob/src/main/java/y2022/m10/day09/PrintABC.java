package y2022.m10.day09;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: LeahAna
 * @Date: 2022/10/9 10:01
 * @Desc:
 */

public class PrintABC {
    /**
     * 问题: A 线程打印 5 次 A，B 线程打印 10 次 B，C 线程打印 15 次 C,按照此顺序循环 10 轮
     */
    // 通信对象：0--打印A  1--打印B 2--打印C
    private int number = 0;

    // 声明锁
    private Lock lock = new ReentrantLock();

    // 声明钥匙A
    private Condition conditionA = lock.newCondition();

    // 声明钥匙B
    private Condition conditionB = lock.newCondition();

    // 声明钥匙C
    private Condition conditionC = lock.newCondition();


    /**
     * A 打印五次
     */
    public void printA(int j) {
        try {
            lock.lock();
            while (number != 0) {
                conditionA.await();
            }
            System.out.println(Thread.currentThread().getName() + "输出 A,第" + j + "轮开始");
            // 输出5次 A
            for (int i = 0; i < 5; i++) {
                System.out.println("A");
            }
            // 开始打印B
            number = 1;
            // 唤醒B
            conditionB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * B 打印10次
     */
    public void printB(int j) {
        try {
            lock.lock();
            while (number != 1) {
                conditionB.await();
            }
            System.out.println(Thread.currentThread().getName() + "输出B，第" + j + "轮开始");

            // 输出10次B
            for (int i = 0; i < 10; i++) {
                System.out.println("B");
            }

            // 开始打印C
            number = 2;

            // 唤醒C
            conditionC.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * C 打印 15 次
     */
    public void printC(int j) {
        try {
            lock.lock();
            while (number != 2) {
                conditionC.await();
            }
            System.out.println(Thread.currentThread().getName() + "输出 C,第" + j + " 轮开始"); //输出 15 次 C
            for (int i = 0; i < 15; i++) {
                System.out.println("C");
            }
            System.out.println("-----------------------------------------"); //开始打印 A
            number = 0; //唤醒 A
            conditionA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

