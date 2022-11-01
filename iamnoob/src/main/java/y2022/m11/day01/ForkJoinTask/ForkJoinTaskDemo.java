package y2022.m11.day01.ForkJoinTask;

import java.util.concurrent.ForkJoinTask;

/**
 * @Author: LeahAna
 * @Date: 2022/11/1 09:10
 * @Desc:
 */

public class ForkJoinTaskDemo {

    // Fork 方法的实现原理：当调用ForkJoinTask的fork方法时，
    // 程序会把任务放在ForkJoinWorkerTread的pushTask的workQueue中，
    // 异步执行这个任务没然后立即返回结果

    // pushTask 方法把当前任务放在ForkJoinTask数组队列里，然后再调用ForkJoinPool的
    // signalWork（）方法唤醒或创建一个工作线程来执行任务。

    // join方法 join 方法的主要作用是阻塞当前线程并等待获取结果。

    // doJoin()方法流程
    // 1.首先通过查看任务的状态，看任务是头已经执行完成，如果执行完成，则直接返回任务状态
    // 2.如果没有执行完，则从任务数组里取出任务并执行。
    // 3.若果任务顺利完成，则设置任务状态为NORMAL，如果出现异常，录异常，并将任务状态设置为
    // EXCEPTIONAL
    // Fork/Join框架异常处理
    // 抛出异常，但是没办法在主线程里捕获异常，所以ForkJoinTask提供了
    // isCompletedAbnormally)()方法判断任务是否已经跑出异常或者取消，
    // 或者通过ForkJoinTask的getException方法获取异常

    // getException方法返回Throwable对象，如果任务被取消则返回CancellationException
    // 如果任务没有完成或者没有跑出异常 测返回null
}
