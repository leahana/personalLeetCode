package y2022.m10.day14;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: LeahAna
 * @Date: 2022/10/14 14:37
 * @Desc:  可以通过为其构造函数提供Callable来常见FutureTask，然后将FutureTask提供给Thread
 *         对象，因此 会间接使用
 * */

public class FutureTaskDemo extends FutureTask {
    public FutureTaskDemo(Callable callable) {
        super(callable);
    }

    public FutureTaskDemo(Runnable runnable, Object result) {
        super(runnable, result);
    }

    // 在主线程将来需要时，就可以通过Future对象在后台完成
    // 通过Future 对象获得后他作业的计算结果或者执行状态
    // 一般FutureTask多用于耗时计算，主线程可以在完成自己的任务后，再去获取结果
    // 仅在计算完成时才能检索结果，如果计算尚未完成 阻塞get方法
    // 一旦计算完成，就不能重新开始或取消计算
    // get方法获取的结果，只有在计算完成时获取，否则就一直阻塞直到任务转入完成状态，然后返回结果或者抛出异常
    // get只计算一次，因此get方法放在最后



}
