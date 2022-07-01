package y2022.m6.day29.Adapter1;

/**
 * @Author: leah_ana
 * @Date: 2022/6/29 12:21
 * @Desc: 类继承的适配器模式
 */

public class Main {

    //通过扮演适配器角色的PrintBanner类来弱化或是强化 hello字符串的展示
    public static void main(String[] args) {
        // PrintBanner 类的实例保存在Print类型的变量中
        // 通过Print 接口编程
        // 对于 Main里面的代码，Banner类和showWithParen方法和showWithAster方法 被完全隐藏
        // 这就好像笔记本电脑只要在12v的电压下就能正常工作，但是并不知道这个12v是通过电源适配器转换过来的

        // Main类并不知道printBanner类是如何实现的，这样就可以在不用对Main类进行修改的情况下改变
        // BannerPrint的具体实现
        Print p= new PrintBanner("hello");
        p.printWeak();
        p.printStrong();
    }

}
