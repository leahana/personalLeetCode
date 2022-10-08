package y2022.m5.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: leah_ana
 * @Date: 2022/5/1 23:36
 */
public class Test {
    private List<Integer> list =new ArrayList<>();

    public static void main(String[] args) {
        final Test test = new Test();

        new Thread() {
            public void run() {
                test.insert(Thread.currentThread());
            }
        }.start();

        new Thread(){
            public void run(){
                test.insert(Thread.currentThread());
            }
        }.start();

    }


    public void insert (Thread thread){
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            System.out.println(thread.getName()+"得到了锁");
            for (int i = 0; i <5 ; i++) {
                list.add(i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(thread.getName()+"释放了锁");
            lock.unlock();
        }
    }
}
