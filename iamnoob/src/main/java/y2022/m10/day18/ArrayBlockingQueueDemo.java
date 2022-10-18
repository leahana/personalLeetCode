package y2022.m10.day18;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: LeahAna
 * @Date: 2022/10/18 10:33
 * @Desc: 阻塞队列（由数组结构组成的有界阻塞队列）
 */

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        // 抛异常
        // 插入：add（e）若满 throw illegalStateException：Queue full
        // 移除：remove（）若空 throw NoSuchElementException
        // 检查：element（）

        // 特殊值
        // 插入：offer（e） 插入方法，成功true失败false
        // 移除：poll（） 移除方法，成功返回出队列的元素，队列里没有就返回null
        // 检查：peek（）

        // 阻塞
        // 插入：put（e） 当阻塞队列满时，生产者线程继续往队列里put元素，队
        // 列会一直阻塞生产者线程直到put数据 or 想用中断推出
        // 移除：take（）当阻塞队列空时，消费者线程试图从队列里take元素，队列会一直阻塞 直到队列可用

        // 超时退出
        // offer（e, time ，unit）
        // poll（time ，unit）
        // 当阻塞队列满时， 队列会阻塞生产者线程一定时间，超过西安时候生产者线程会退出

        List list = new ArrayList();

        // 第一组
/*
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.element());


        System.out.println(blockingQueue.add("x"));
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());*/

     //第二组
     System.out.println(blockingQueue.offer("a"));
     System.out.println(blockingQueue.offer("b"));
     System.out.println(blockingQueue.offer("c"));
     System.out.println(blockingQueue.offer("x"));
     System.out.println(blockingQueue.poll());
     System.out.println(blockingQueue.poll());
     System.out.println(blockingQueue.poll());
     System.out.println(blockingQueue.poll());

/*     // 第三组
     blockingQueue.put("a");
     blockingQueue.put("b");
     blockingQueue.put("c");
     blockingQueue.put("x");
     System.out.println(blockingQueue.take());
     System.out.println(blockingQueue.take());
     System.out.println(blockingQueue.take());
     System.out.println(blockingQueue.take());

     //第四组
     System.out.println(blockingQueue.offer("a"));
     System.out.println(blockingQueue.offer("b"));
     System.out.println(blockingQueue.offer("c"));
     System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));
   */

        //

    }
}


