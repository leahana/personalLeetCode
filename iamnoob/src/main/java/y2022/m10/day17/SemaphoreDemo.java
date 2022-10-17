package y2022.m10.day17;

import java.util.SimpleTimeZone;
import java.util.concurrent.Semaphore;

/**
 * @Author: LeahAna
 * @Date: 2022/10/17 10:00
 * @Desc: UC三大辅助类--信号灯Semaphore
 */

public class SemaphoreDemo {
    // Semaphore的构造方法中传入的第一个参数是最大信号量，（可以看成最大线程池），每个信号量
    // 初始化为一个最多只能分发一个许可证，使用acquire方法许可证，release方法释放许可


    // 场景 ：抢车位，6部汽车，3个停车位

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6; i++) {
            Thread.sleep (100);

            // 停车
            new Thread(() ->{

                try {
                    System.out.println(Thread.currentThread().getName()+"找车位ing");
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"汽车停车成功");

                Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(Thread.currentThread().getName()+"溜了溜了");
                    semaphore.release();
                }

            },"汽车"+i).start();
        }

    }
}
