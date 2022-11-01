package y2022.m11.day01.ForkJoinTask;

import java.util.concurrent.RecursiveTask;

/**
 * @Author: LeahAna
 * @Date: 2022/11/1 10:53
 * @Desc: 服务拆分案例
 */

public class TaskExample extends RecursiveTask<Long> {
    private int start;
    private int end;
    private long sum;

    public TaskExample() {
    }

    public TaskExample(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        System.out.println("任务"+start+"======"+end+"累加开始");
        // 大于100个相加切分，小于直接加
        if(end-start<=100){
            for (int i = start;i<=end;i++){
                // 累加
                sum+=i;
            }
        }else {
            // 切分两块
            int middle=start+100;
            // 递归调用，切分成两个小任务
            TaskExample t1 = new TaskExample(start, middle);
            TaskExample t2 = new TaskExample(middle+1,end);
            // 执行：异步
            t1.fork();
            t2.fork();
            // 同步阻塞获取执行结果
            sum = t1.join() + t2.join();
        }
        return sum;
    }

}
