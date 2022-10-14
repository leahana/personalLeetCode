package y2022.m10.day14;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author: LeahAna
 * @Date: 2022/10/14 14:23
 * @Desc:
 */

public class FutureDemo implements Future {


    // 用于停止任务
    // 如果尚未启动，他将停止任务。如果已经启动，则仅在mayInterrupt为true时任务才中断
    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    //
    @Override
    public boolean isCancelled() {
        return false;
    }

    // 如果任务完成，则返回true 否则返回false
    // Callable与Runnable类似， 封装了一个要在另一个程序上运行的任务，
    // 而Future用于储存从另一个线程获得的结果实际上，Future和Runnable 可以一起用
    // 要创建线程 需要Runnable ，为了获取结果，则需要Future
    @Override
    public boolean isDone() {
        return false;
    }


    // 用于获取任务的结果
    // 如果任务完成，他将立即返回结果，否则等待任务完成，然后返回结果。
    @Override
    public Object get() throws InterruptedException, ExecutionException {
        return null;
    }

    @Override
    public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return null;
    }
}
