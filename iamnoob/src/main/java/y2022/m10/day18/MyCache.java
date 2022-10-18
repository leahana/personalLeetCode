package y2022.m10.day18;

import sun.awt.windows.ThemeReader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: LeahAna
 * @Date: 2022/10/18 09:17
 * @Desc:
 */

public class MyCache {

    private volatile Map<String, Object> map = new HashMap<>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        // 添加写锁
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "正在写操作" + key);
            // 暂停一会
            TimeUnit.MICROSECONDS.sleep(300);
            // 存放数据
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写完了" + key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 释放写锁
            readWriteLock.writeLock().unlock();
        }

    }

    // 读数据
    public Object get(String key) {
        // 添加读锁
        readWriteLock.readLock().unlock();
        Object result = null;
        try {
            System.out.println(Thread.currentThread().getName() + "正在读操作" + key);
            TimeUnit.MICROSECONDS.sleep(300);
            result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读操作完成" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放锁
            readWriteLock.readLock().unlock();

        }
        return result;
    }

    // 小结
    // 在线程持有读锁的情况下，该线程不能取得写锁
    // （因为获取写锁的时候，如果发现当前的读锁被占用，就马上获取失败，不管读锁是不是被当前线程持有）
    // 在线程持有写锁的情况下，该线程可以继续获取读锁
    // （获取读锁时如果发现写锁被占用，是有写锁没有被当前线程占用的情况下才会获取失败）
    // 原因：当线程获取读锁的时候，可能有其他线程也在持有读锁，因此不能把获取读锁的线程"升级"为写锁
    //      而对于获得写锁的线程，他一定占了写锁，因此可以继续让他获取读锁，当他同时获取了写锁和读锁后
    //      哈可以先释放写锁继续保持读锁，这样就一个写锁就"降级为了读锁"

}
