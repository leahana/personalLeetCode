package y2022.m10.day14;

import java.util.concurrent.Callable;

/**
 * @Author: LeahAna
 * @Date: 2022/10/14 10:14
 * @Desc:
 */

// 实现Runnable接口
public class ThreadDemo implements Runnable {

    @Override
    public void run() {

    }
}

// 新类 实现Callable接口
class ThreadDemo2 implements Callable{

    @Override
    public Object call() throws Exception {
        return null;
    }

    // call可以引发异常 run不能
    // 不能直接替换Runnable Thread类的构造方法没有Callable
}
