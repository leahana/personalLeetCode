package y2022.m5.day01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: LeahAna
 * @Date: 2022/10/8 09:43
 * @Desc:
 */
public class Ticket {

    private int number = 30;

    public synchronized void sale() {
        if (number > 0) {
            System.out.println(Thread.currentThread().getContextClassLoader() +
                    "：卖出==>" + (number--) + " 剩下 ：" + number);
        }
    }

    // 创建读写锁
    final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    // 获取读锁
    final ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();

    // 获取写锁
    final ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    public void test() {
        readLock.lock();

        try {
            // 业务代码
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }

        // 写锁使用
        writeLock.lock();

        try {
            // 业务代码
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }
}
