package y2022.m10.day08;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: LeahAna
 * @Date: 2022/10/8 09:14
 * @Desc:
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
    // 1.synchronized是java关键字 内置特性，Lock不是java内置的。Lock是一个接口

    // 2.synchronized在发生异常的时候会自动释放线程占有的锁，不会死锁，Lock发生异常如果没有通过unLock（）
    //   去释放锁，很容易造成思索，因此使用lock时需要在finally块中释放锁

    // 3.Lock可以让锁的等待线程响应中断，而synchronized却不行，使用synchronized时，等待的线程会一
    //   直等待下去，不能够响应中断
    // 4.通过Lock可以知道有没有成功获取锁，而synchronized却无法办到
    // 5.Lock可以提高多个线程的使用效率（ReadWriteLock）读写锁  提高多个线程进行读的效率
    // 竞争资源不激烈，两者性能差不多，竞争资源非常激烈 Lock性能远远优于synchronized


}
