package y2022.m10.day25;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: LeahAna
 * @Date: 2022/10/25 09:43
 * @Desc: 线程池
 */

public class ThreadPoolTest {

    /** 出现原因：线程过多会带来调度开销，进而影响缓存局部性和整体性能
     *
     * 线程池的优势：线程池做的工作只是控制运行线程的 数据处理过程中将任务放入队列，
     * 然后在线程创建后启动这些任务，如果线程数量超过了最大数量，超出数量的线程排队等候
     * 等其他线程执行完毕，再从队列中取出任务来
     *
     *
     * 特点：
     * 1 降低资源消耗：通过重复利用与创建的线程降低线程创建和销毁的消耗。
     * 2 提高响应速度，当任务到达时，任务可以不需要等待线程创建完成就能立即执行
     * 3 提高线程的可管理性：线程本来就是稀缺资源，如果无限制的创建，不仅会消耗系统资源，
     *   还会降低系统的稳定性，使用线程池可以统一进行分配，调优和监控
     *
     */

    /**
     * corePoolSize 线程池的核心线程数
     * maximumPoolSize 能容纳的最大线程数
     * keepAliveTime 空闲线程存活时间
     * unit 存活的时间单位
     * workQueue 存放提交但未执行任务的队列
     * threadFactory 创建线程的工厂类:可以省略
     * handler 等待队列满后的拒绝策略:可以省略
     */
    // 默认线程池 最大线程数量是int 最大值
    public void test() {


    }

}
