package y2022.m11.day01.ForkJoinTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @Author: LeahAna
 * @Date: 2022/11/1 14:40
 * @Desc: 分支合并案例
 */

public class ForkJoinPoolDemo {
    public static void main(String[] args) {
        // 定义任务
        TaskExample taskExample = new TaskExample(1, 1000);
        // 定义执行对象
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // 加入执行任务
        ForkJoinTask<Long> result = forkJoinPool.submit(taskExample);

        // 输出结果
        try {
            System.out.println(result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            forkJoinPool.shutdown();
        }
    }

}
