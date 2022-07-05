package y2022.m7.day05.Prototype;

import y2022.m7.day05.Prototype.framework.Product;

/**
 * @Author: LeahAna
 * @Date: 2022/7/5 08:56
 * @Desc: 将字符串放入方框中并使其显示出来的类，实现了use 方法和 createClone 方法
 */

public class MessageBox implements Product {

    private char decochar;

    public MessageBox(char decochar) {
        this.decochar = decochar;
    }

    @Override
    public void user(String s) {
        int length = s.getBytes().length;
        for (int i = 0; i < length + 4; i++) {
            System.out.print(decochar);
        }
        System.out.println("");
        System.out.println(decochar + " " + s + " " + decochar);
        for (int i = 0; i < length + 4; i++) {
            System.out.print(decochar);
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
