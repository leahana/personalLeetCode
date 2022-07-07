package y2022.m7.day05.Prototype.framework;



/**
 * @Author: LeahAna
 * @Date: 2022/7/5 08:57
 * @Desc: 给字符串加上上下划线，并使其显示出来的类 实现了 use 和 createClone 方法
 */

public class UnderlinePen implements Product {
    private char ulchar;

    public UnderlinePen(char ulchar) {
        this.ulchar = ulchar;
    }

    @Override
    public void user(String s) {
int length= s.getBytes().length;
        System.out.println("\""+s+"\"");
        System.out.print(" ");
        for (int i = 0; i < length; i++) {
            System.out.print(ulchar);
        }
        System.out.println("");
    }

    @Override
    public Product createClone() {
        Product p = null;

        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
