package y2022.m11.day02;

import org.omg.CORBA.INTERNAL;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

/**
 * @Author: LeahAna
 * @Date: 2022/11/2 09:02
 * @Desc:
 */

public class CompletableFutureDemo {
    // CompletableFuture在java里面被用于异步编程，通常意味着非阻塞，
    // 可以使得我们的任务单独运行在于主线程分离的其他线程中，并且通过
    // 回调可以在主线程中的到异步任务的执行状态，是否完成，是否异常等信息

    // CompletableFuture实现了Future，CompletionStage接口，实现了Future
    // 接口就可以兼容现有线程池框架，而CompletionStage接口才是异步编程的抽象接口，
    // 里面定义多种异步方法，通过这两者集合，从而打造出了强大的CompletableFuture类

    // Future与CompletableFuture

    // Future在java里面，通常用来表示一个异步任务的引用，比如我们将任务提交到线程池里面，
    // 然后我们会得到一个Future里面有isDone方法来判断任务是否处理结束，还有get方法可以一直阻塞
    // 直到任务结束然后获取结果，单整体来说这种方式，还是同步的，因为客户端不断阻塞等待或者不断
    // 轮询才能直到任务是否完成


    // Future只要缺点如下：
    // 1）不支持手动完成
    // 2）不支持进一步的非阻塞调用
    // 3）不支持链式调用
    // 4）不支持多个Future合并
    // 5）不支持异常处理

    /**
     * 主线程里面创建一个CompletableFuture 然后主线程调用get方法会阻塞
     * 最后我们在一个主线程中是使其终止
     */
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future = new CompletableFuture<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "子线程开始干活");
                // 子线程睡五秒
                Thread.sleep(5000);
                future.complete("success");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();
        // 主线程调用get方法阻塞
        System.out.println("主线程调用get方法获取结果为：" + future.get());
        System.out.println("主线程完成，阻塞结束！");

        System.out.println("----noReturn----");
        noReturn();
        System.out.println("----thenApply----");
        thenApply();
        System.out.println("----exceptionally----");
        exceptionally();
        System.out.println("----handle----");
        handle();


    }

    public static void noReturn() throws ExecutionException, InterruptedException {
        System.out.println("主线程开始");
        // 运行一个没有返回值的异步任务
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("子线程启动干活");
                Thread.sleep(5000);
                System.out.println("子线程完成");

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        // 主线程阻塞

        future.get();
        System.out.println("主线程结束");
    }

    /**
     * 先对一个数+10 然后取平方
     */
    private static Integer num = 10;

    public static void thenApply()  throws Exception{
        System.out.println("主线程开始");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(
                () -> {
                    try {

                        System.out.println("加10 任务开始");
                        num += 10;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return num;

                }).thenApply(integer -> num * num);
        Integer integer = future.get();
        System.out.println("主线程结束，自线程结果为"+integer);
    }

    public static void thenAcceptTest(){
        System.out.println("主线程开始");
        CompletableFuture.supplyAsync(() -> {
            System.out.println("加10任务开始");
            num+=10;
            return num;

        }).thenApply(integer -> num*num).thenAccept(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("子线程全部处理完成，最后调用了accept 结果为："+integer);
            }
        });
    }

    public static void exceptionally() throws ExecutionException, InterruptedException {

        System.out.println("主线程开始");

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
        int i= 1/0;
            System.out.println("加10任务开始");
            num += 10;
            return num;

        }).exceptionally(ex->{
            System.out.println(ex.getMessage());
            return -1;
        });
        System.out.println(future.get());
    }

    public static void handle() throws ExecutionException, InterruptedException {
        System.out.println("主线程开始");
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("加10任务开始");
            num += 10;
            return num;
        }).handle((i, ex) -> {
            System.out.println("进入handle方法");
            if (ex != null) {
                System.out.println("发生了异常，内容为：" + ex.getMessage());
                return -1;
            } else {
                System.out.println("正常完成 内容为：" + i);

                return i;
            }
        });
        System.out.println(future.get());

    }
}
