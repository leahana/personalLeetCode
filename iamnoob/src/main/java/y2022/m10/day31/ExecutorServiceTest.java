package y2022.m10.day31;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: LeahAna
 * @Date: 2022/10/31 09:19
 * @Desc:
 */

public class ExecutorServiceTest {

    // 场景：适用于可以预测线程数量的业务中，或者服务器负载格限制的场景
    public static ExecutorService newFixedThreadPool() {
        return new ThreadPoolExecutor(
                10,
                10,
                0L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()

        );
    }

    public static ExecutorService newSingleThreadExecutor() {
        // 作用： 创建一个shying单个worker线程的Executor
        // 特征： 线程池中最多执行一个线程，之后提交的线程活动将会排在队列中依次执行
        // 场景： 适用于需要保证顺序执行各个任务，并且在任意时间点不会同时有多个线程的场景
        return new ThreadPoolExecutor(1,
                1,
                0L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

    }

    public static ThreadPoolExecutor newScheduledThreadPool(int corePoolSize, ThreadFactory threadFactory) {
        // 作用： 线程支持定时一集周期性的执行任务，创建一个corePoolSize为传入参数，最大线程数为整形的最大数的线程池（int最大值
        // 特征： 1）线程池中具有指定数量的线，即便是空线程 也将保留
        //       2）可定时或者延迟执行线程活动
        // 场景：适用于需要多个线程执行周期任务的场景
        return new ScheduledThreadPoolExecutor(corePoolSize, threadFactory);
    }

    public static ExecutorService newWorkStealingPool(int parallelism){
        /**
         * parallelism ：并行级别， 通常默认为JVM可用的处理器个数
         * factory：用于创建ForkJoinPool中使用的线程
         * handler：用于处理工作线程为处理的异常，默认为null，
         * asyncMode：用于控制WorkQueue的工作模式：队列--反队列
         */
        return new ForkJoinPool(
                parallelism,
                ForkJoinPool.defaultForkJoinWorkerThreadFactory, null, true);
    }
    // 场景： 适用于大耗时，可并行执行的场景

}
