package y2022.m10.day09;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: LeahAna
 * @Date: 2022/10/9 09:31
 * @Desc: volatile关键字实现线程交替加减
 */

public class TestVolatile {
    public static void main(String[] args) {
        DemoClassForSynchronized demoClass = new DemoClassForSynchronized();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                demoClass.increment();
            }
        }, "线程1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                demoClass.decrement();
            }
        }, "线程2");


        DemoClassForLock dcl = new DemoClassForLock();
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                dcl.increment();
            }
        }, "线程3");
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                dcl.decrement();
            }
        }, "线程4");


//        t1.start();
//        t2.start();
        t3.start();
        t4.start();


    }

}

class DemoClassForSynchronized {

    //加减对象
    private int number = 0;

    /**
     * 加1
     */
    public synchronized void increment() {
        try {
            while (number != 0) {
                this.wait();
            }
            number++;
            System.out.println("--------" + Thread.currentThread().getName() + "加一成 功----------,值为:" + number);
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 减一
     */
    public synchronized void decrement() {
        try {
            while (number == 0) {
                this.wait();
            }
            number--;
            System.out.println("--------" + Thread.currentThread().getName() + "减一成 功----------,值为:" + number);
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

class DemoClassForLock {
    //加减对象
    private int number = 0;

    //声明锁
    private Lock lock = new ReentrantLock();

    //声明钥匙
    private Condition condition = lock.newCondition();

    /**
     * 加1
     */
    public void increment() {
        try {
            lock.lock();
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println("--------" + Thread.currentThread().getName() + "加一成 功----------,值为:" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    /**
     * 减一
     */
    public void decrement() {
        try {
            lock.lock();
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println("--------" + Thread.currentThread().getName() + "减一成 功----------,值为:" + number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
