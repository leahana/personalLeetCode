package y2022.m7.day05.Singleton;

/**
 * @Author: LeahAna
 * @Date: 2022/7/5 08:30
 * @Desc: 只存在一个实例的类
 */

public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton() {
        System.out.println("生成了一个实例。");
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}
