package y2022.m7.day07.Bridge;

/**
 * @Author: LeahAna
 * @Date: 2022/7/7 14:56
 * @Desc: 测试程序运行的类
 */

public class Main {

    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("hello world"));
        Display d2 = new CountDisplay(new StringDisplayImpl("hello china"));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("hello universe"));

        d1.display();
        d2.display();
        d3.display();
        d3.multiDisplay(5);

    }

}
