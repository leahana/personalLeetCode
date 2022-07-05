package y2022.m7.day05.Singleton;

/**
 * @Author: LeahAna
 * @Date: 2022/7/5 08:31
 * @Desc: 测试程序运行的类
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("start");

        Singleton obj1 = Singleton.getSingleton();
        Singleton obj2 = Singleton.getSingleton();
        if (obj1==obj2){
            System.out.println("obj1和obj2 是同一个实例");
        }else {
            System.out.println("obj1和obj2 是不同实例");
        }
        System.out.println(obj1);
        System.out.println(obj2);

        System.out.println("end");
    }
}
