package y2022.m7.day13;

/**
 * @Author: LeahAna
 * @Date: 2022/7/13 08:37
 * @Desc: 测试程序运行的类
 */

public class Main {
    public static void main(String[] args) {
        Display b1 = new StringDisplay("hello world");
        Display b2 = new SideBorder(b1, '#');
        Display b3 = new FullBorder(b2);

        b1.show();
        b2.show();
        b3.show();

        Display b4 =
                new SideBorder(
                        new FullBorder(
                                new FullBorder(
                                        new SideBorder(
                                                new FullBorder(
                                                        new StringDisplay("你好世界")), '*'))), '/');
        b4.show();
    }
}
