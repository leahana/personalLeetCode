package y2022.m10.day12;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: LeahAna
 * @Date: 2022/10/12 08:52
 * @Desc:
 */

public class NotSafeDemo {
    // ConcurrentModificationException 并发修改异常
/*
    public static void main(String[] args) {
        List list = new ArrayList();

        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
            },"线程"+i).start();
        }
    }
*/
/*    public static void main(String[] args) {
        // 矢量队列 实现了List，RandomAccess，Cloneable 这些接口，继承了AbstractList，实现了list
        // 是队列，支持添加修改删除比那里 ，提供了随机访问功能
        // Vector的add方法有synchronized修饰
        List list = new Vector();// 线程安全
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
            },"线程"+i).start();
        }
    }*/
    public static void main(String[] args) {
        List list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString());
                System.out.println(list);
            },"线程"+i).start();
        }
        new CopyOnWriteArrayList();

    }
}
