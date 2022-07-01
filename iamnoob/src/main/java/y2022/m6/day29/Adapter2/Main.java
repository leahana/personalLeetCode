package y2022.m6.day29.Adapter2;

import y2022.m6.day29.Adapter1.Banner;

/**
 * @Author: leah_ana
 * @Date: 2022/6/29 12:33
 * @Desc: 使用委托的适配器
 */

public class Main {

    // 在Java 语言中， 委托就是将某个方法中的实际处理 交给其他实例的方法
    public static void main(String[] args) {
        Print print = new PrintBanner(new Banner("hello"));
        print.printStrong();
        print.printWeak();
    }

//    模式中登场的角色

    // Target 对象：该角色负责定义所需方法，即笔记本电脑工作所需的直流12v电源，由Print接口和Print扮演此角色

    // Client 请求者：该角色负责使用Target角色所定义的方法进行具体处理，即直流12v电源所驱动的电脑，Main类扮演此角色

    // Adaptee 被适配角色 持有即定方法的角色，即100v直流电源，Banner类扮演此角色，如果方法与target所需方法相同，
    // 即不用Adapter角色

    // Adapter 适配角色，Apapter角色的主人公，使用Adaptee角色的方法来满足Target角色的需求，就是把100v直流电源转换
    // 成直流12v的适配器， 在实例程序中，PrintBanner类扮演这个角色



    // 什么时候使用Adapter模式
    // 很多时候我们并非从零开始编程，经常会用到现有的类，特别是当现有的类已经被充分测试过，我们更愿意将这些类作为组件
    // 重复利用，通过该模式可以很方便的创建我们需要的方法群，当出现bug时，我们很明确的知道bug不再现有的类，所以只需要
    // 调查扮演Adapter的类即可，这样一来，代码问题的排查就会简单许多

    /**
     *    如果要对已经测试完毕的现有代码进行修改，就必须在修改后重新进行测试，使用Adapter模式可以完全在不改变现有代码的
     *    前提下实现现有代码适配于新的接口，，此外在Adapter模式中并非一定需要现有代码 ，只要现有类的功能，就可以编出新的
     *    类。
     */
}
