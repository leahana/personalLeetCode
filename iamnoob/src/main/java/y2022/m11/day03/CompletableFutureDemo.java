package y2022.m11.day03;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * @Author: LeahAna
 * @Date: 2022/11/3 08:54
 * @Desc:
 */

public class CompletableFutureDemo {

    private static Integer num = 10;

    // thenCombine合并两个没有依赖关系的completableFutures任务
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("主线程开始");
        CompletableFuture<Integer> job1 = CompletableFuture.supplyAsync(() -> {

            System.out.println("加10任务开始");
            num += 10;

            return num;
        });
        CompletableFuture<Integer> job2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("乘10任务开始");
            num *= 10;
            return num;
        });

        // 合并两个结果
        CompletableFuture<Object> future = job1.thenCombine(job2, new BiFunction<Integer, Integer, Object>() {
            @Override
            public Object apply(Integer a, Integer b) {
                List<Integer> list = new ArrayList<>();
                list.add(a);
                list.add(b);
                return list;
            }
        });
        System.out.println("合并结果为：" + future.get());
        System.out.println("----allOf----");
        allOf();
        System.out.println("----anyOf----");
        anyOf();

    }

    // 合并多个任务的结果allOf与anyOf
    // allOf：一系列独立的future任务，等其所有的任务执行完后做一些事情

    /**
     * 先对一个数加10，然后取平方
     */
    public static void allOf() {
        System.out.println("主线程开始");
        List<CompletableFuture> list = new ArrayList<>();
        CompletableFuture<Integer> job1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("加10任务开始");
            num += 10;
            return num;
        });
        list.add(job1);
        CompletableFuture<Integer> job2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("乘10任务开始");
            num *= 10;
            return num;
        });
        list.add(job2);
        CompletableFuture<Integer> job3 = CompletableFuture.supplyAsync(() -> {
            System.out.println("减以 10 任务开始");
            num = num * 10;
            return num;
        });
        list.add(job3);

        CompletableFuture<Integer> job4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("除以 10 任务开始");
            num = num * 10;
            return num;
        });
        list.add(job4);
        // 多任务合并
        List<Object> collect = list.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println(collect);
    }

    // anyOf只要在等多个future里面又一个返回，整个任务就可以结束，而不需要的呢感动啊每一个future结束

    public static void anyOf() throws ExecutionException, InterruptedException {
        System.out.println("主线程开始");
        CompletableFuture<Integer>[] futures = new CompletableFuture[4];
        CompletableFuture<Integer> job1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("睡眠5秒");
            try {
                Thread.sleep(5000);
                System.out.println("加10任务开始");
                num += 10;
                return num;
            } catch (InterruptedException e) {
                return 0;
            }

        });

        futures[0] = job1;
        CompletableFuture<Integer> job2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("乘以 10 任务开始");
                num = num * 10;
                return num;
            } catch (Exception e) {
                return 1;
            }

        });
        futures[1] = job2;

        CompletableFuture<Integer> job3 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("减以 10 任务开始");
                num = num * 10;
                return num;
            } catch (Exception e) {
                return 2;
            }

        });
        futures[2] = job3;
        CompletableFuture<Integer> job4 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(4000);
                System.out.println("除以 10 任务开始");
                num = num * 10;
                return num;
            } catch (Exception e) {
                return 3;
            }

        });

        futures[3] = job4;
        CompletableFuture<Object> future = CompletableFuture.anyOf(futures);
        System.out.println(future.get());

    }

}
