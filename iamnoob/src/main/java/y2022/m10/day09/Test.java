package y2022.m10.day09;

/**
 * @Author: LeahAna
 * @Date: 2022/10/9 09:26
 * @Desc:
 */

public class Test {
 //线程通信的模型：共享内存和消息传递
    // 场景：两个线程， 一个线程对当前树脂加1 另一个线程对当前线程减1 要求 线程间通信
 public static void main(String[] args){

     PrintABC demoClass = new PrintABC();

     new Thread(() ->{

         for (int i = 1; i <= 10; i++) {

             demoClass.printA(i);

         } }, "A 线程").start();

     new Thread(() ->{

         for (int i = 1; i <= 10; i++) { demoClass.printB(i);

         } }, "B 线程").start();

     new Thread(() ->{ for (int i = 1; i <= 10; i++) { demoClass.printC(i); } }, "C 线程").start();

 }

}



