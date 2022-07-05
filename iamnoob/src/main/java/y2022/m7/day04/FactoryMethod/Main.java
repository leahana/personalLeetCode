package y2022.m7.day04.FactoryMethod;

import y2022.m7.day04.FactoryMethod.framework.Factory;
import y2022.m7.day04.FactoryMethod.framework.Product;
import y2022.m7.day04.FactoryMethod.idcard.IDCardFactory;

/**
 * @Author: LeahAna
 * @Date: 2022/7/4 08:47
 * @Desc:
 */

public class Main {

    public static void main(String[] args) {
        Factory factory = new IDCardFactory();

        Product card1 = factory.create("小红");
        Product card2 = factory.create("小明");
        Product card3 = factory.create("小刚");
        card1.use();
        card2.use();
        card3.use();


        /**
         * Factory Method 中出现的角色
         *
         *
         * Product 产品
         * 属于框架一方，是一个抽象类，定义了在FactoryMethod模式中生成那些实例所持有的接口，但具体的处理由子类
         * ConcreteProduct角色决定
         *
         * Creator 创建者
         * 属于框架一方，负责生成，Product 角色的抽象类，但是具体的处理由子类ConcreteCreator角色决定。creator角色
         * 对实际负责生成实例的ConcreteCreator 唯一知道的就是，要调用Product角色 和生成实例的方法。
         * 就可以生成Product 的实例
         *
         * ConcreteProduct 具体的产品
         * 属于具体加工一方，它决定了具体的产品。
         *
         * ConcreteCreator 具体的创建者
         * 属于加工厂这一方，负责生产具体的产品。
         *
         */
    }
}
