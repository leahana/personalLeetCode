package y2022.m5.day01;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: LeahAna
 * @Date: 2022/10/8 16:15
 * @Desc:
 */

public class ReadWriteTest {


    public static void main(String[] args) {

        // 创建读写锁
        final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        // 创建读锁
        final ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        // 创建写锁
        final ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

        Thread t1 = new Thread(() -> {
            readLock.lock();
            try {
                System.out.println("[t1]得到读锁");
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("[t1]释放读锁");
                readLock.unlock();
            }
        });
        Thread t2 = new Thread(() -> {
            readLock.lock();
            try {
                System.out.println("[t2]得到读锁");
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("[t2]释放读锁");
                readLock.unlock();
            }
        });

        Thread t3 = new Thread(() -> {
            writeLock.lock();
            try {
                System.out.println("[t3]得到写锁");
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("[t3]释放写锁");
                writeLock.unlock();

            }
        });
        Thread t4 = new Thread(() -> {
            writeLock.lock();
            try {
                System.out.println("[t4]得到写锁");
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("[t4]释放写锁");
                writeLock.unlock();

            }
        });
//   t1 t2 读读不互斥  t1 t3 读写互斥 t3 t4写写互斥
//        t1.start();
//        t2.start();
        t3.start();
        t4.start();
    }
    // 优点分析 ： 提高了程序执行性能，多个读锁可以同时执行，比普通锁性能更好，
    // 避免脏读，读写互斥，保证不会读到写了一半的数据
    // 适用场景： 读多写少的场景
}
