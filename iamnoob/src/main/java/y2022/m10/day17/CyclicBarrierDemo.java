package y2022.m10.day17;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * @Author: LeahAna
 * @Date: 2022/10/17 09:34
 * @Desc: JUC三大辅助类--CyclicBarrier(循环栅栏)
 */

public class CyclicBarrierDemo {
    // Cyclic （adj. 环的；循环的；周期的）Barrier（障碍物，屏障；界线）
    // CyclicBarrier 构造方法第一个参数是目标障碍数，每次执行cyclicBarrier一次障碍数会+1，
    // 如果达到了目标障碍数，才会执行 cyclicBarrier.await()之后的语句，可以将CyclicBarrier
    // 理解为+1操作

    // 场景： 集齐七颗龙珠就可以召唤神龙

    private final static int NUMBER = 7;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUMBER,()->{
            System.out.println("集齐" + NUMBER + "颗龙珠，现在召唤神龙");
        });
        // 定义七个线程分别去收集龙珠
        for (int i = 1; i <= 7; i++) {
            new Thread(() -> {
                try {
                    if (Thread.currentThread().getName().equals("龙珠3号")) {
                        System.out.println("龙珠3号抢夺战开始");
                        Thread.sleep(5000);
                        System.out.println("龙珠3号抢夺战结束，拿到了龙珠3号");
                    }else {
                        System.out.println(Thread.currentThread().getName()+"收集到了");
                    }
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            },"龙珠"+i+"号").start();
        }

    }



}
