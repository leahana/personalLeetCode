package y2022.m7.day05.Prototype;

import y2022.m7.day05.Prototype.framework.Manager;
import y2022.m7.day05.Prototype.framework.Product;
import y2022.m7.day05.Prototype.framework.UnderlinePen;

/**
 * @Author: LeahAna
 * @Date: 2022/7/5 08:54
 * @Desc: 测试程序运行的类
 */

public class Main {
    public static void main(String[] args) {
        Manager manager=new Manager();
        UnderlinePen underlinePen=new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        manager.register("strong message",underlinePen);
        manager.register("warning box",mbox);
        manager.register("slash box",sbox);

        // 生成
        Product p1=manager.createClone("strong message");
        p1.user("hello world");
        Product p2=manager.createClone("warning box");
        p2.user("hello world");
        Product p3=manager.createClone("slash box");
        p3.user("hello world");
    }
}
