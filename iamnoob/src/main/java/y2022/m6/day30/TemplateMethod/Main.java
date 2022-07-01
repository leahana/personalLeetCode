package y2022.m6.day30.TemplateMethod;

/**
 * @Author: leah_ana
 * @Date: 2022/6/30 08:47
 * @Desc: 测试程序
 */

public class Main {
    public static void main(String[] args) {
        // 生成一个持有"H" 的CharDisplay类的实例
        AbstractDisplay d1 = new CharDisplay('H');
        // 生成一个持有"Hello,world."的StringDisplay的实例
        AbstractDisplay d2 = new StringDisplay("Hello,world.");
        // 生成一个持有"你好，世界。"的StringDisplay实例
        AbstractDisplay d3 = new StringDisplay("你好，世界");

        d1.display();   // 由于d1,d2,d3都继承AbstractDisplay
        d2.display();   // 可以调用display方法
        d3.display();   // 实际程序取决于 CharDisplay和StringDisplay类的具体实现

        // 登场角色：
        /**
         * AbstractClass 抽象类
         * 不仅负责实现模版方法，还负责声明在模版方法中使用的抽象方法。这些方法由子类ConcreteClass 角色负责实现
         * 在实例程序中，由AbstractDisplay方法类扮演此角色
         *
         *
         * ConcreteClass 具体类
         * 该角色负责具体实现AbstractClass角色中定义的抽象方法，这里实现的方法会在AbstractClass角色模版方法中被
         * 调用。
         * 在实例程序中，由CharDisplay类和StringDisplay 类扮演此角色
         *
         *
         * 优点：
         *
         *
         * 1.使逻辑处理通用化
         * 在父类的模版方法中编写算法，无需在每个子类中再编写算法
         *
         * 2.父类和子类之间的协作
         * 在Template Method模式中， 父类和子类是紧密联系，共同工作的，因此 在子类中实现父类中声明的抽象方法时，
         * 必须要理解这些抽象方法被调用的时机，在看不到父类源代码的情况下，想要编出子类是非常困难的
         *
         *
         * 3.父类和子类的一致性
         *  在实例程序中，不论是CharDisplay实例还是StringDisplay实例，都是先保存在AbstractDisplay类型的变量中，
         *  然后再来调用display方法的
         *  即使没有用 instanceof 等指定子类的种类，程序也能正常工作
         *
         *  无论在父类类型的变量中保存哪个子类的实例，程序都可以正常工作，这种原则被称为
         *  里氏替换原则
         *  The LisKov Substitution Principle ， LSP
         *  当然LSP 并非仅限于 Template Method 模式  它是通用的继承原则
         *
         *
         *
         *
         * 相关的设计模式：Factory Method模式，Strategy模式
         *
         * 父类对子类的要求：
         *    ·在子类中可以使用父类定义的方法，
         *    ·可以通过在子类中增加方法以实现新的功能，
         *    ·在子类中重写父类的方法可以改变程序的行为
         *
         *    声明抽象方法是希望达到以下目的：
         *      ·期待子类去实现抽象方法
         *      ·要求子类去实现抽象方法（ interface 接口  一种规则
         *
         *   虽然具体处理内容是由子类决定的，不过在抽象阶段确定处理的流程非常重要
         *
         *
         *  父类与子类之间的协作
         * 虽然将更多方法的实现放在父类中会让子类变得更加轻松，但是同时降低了子类的灵活性，高耦合，反之，如果父类中实现的
         * 方法锅烧，子类就会变得臃肿不堪，导致各子类间的代码出现重复
         */

    }
}
