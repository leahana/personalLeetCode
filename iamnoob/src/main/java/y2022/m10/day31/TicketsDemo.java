package y2022.m10.day31;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: LeahAna
 * @Date: 2022/10/31 14:06
 * @Desc: 三售票口案例
 */

public class TicketsDemo {


    public static void main(String[] args) {
        ExecutorService executorService =
                new ThreadPoolExecutor(
                        3,
                        3,
                        60L,
                        TimeUnit.SECONDS,
                        new LinkedBlockingDeque<>(),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.DiscardOldestPolicy());

        try {
            // 十人买票
            for (int i = 1; i <= 10; i++) {
                executorService.execute(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName() + "窗口开始卖票");
                        Thread.sleep(5000);
                        System.out.println(Thread.currentThread().getName() + "窗口卖票结束");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 完成后结束
            executorService.shutdown();
        }
        // 阿里巴巴java开发手册：
        // 【强制】线程池不允许使用Executors创建，而是通过ThreadPoolExecutor的方式处理
        //  明确线程池运行规则，规避资源耗的风险，
        //  说明： Executors返回的线程池对象的弊端如下
        // 1）FixedThreadPool和SingleThreadPool：
        //    允许的请求【队列长度】为Integer.MAX_VALUE，可能会堆积大量的【请求】，从而导致OOM。
        // 2）CachedThreadPool和ScheduledThreadPool：
        //    允许的创建【线程数量】为Integer.MAX_VALUE, 可能会创建大量的【线程】，从而导致OOM
    }
}
