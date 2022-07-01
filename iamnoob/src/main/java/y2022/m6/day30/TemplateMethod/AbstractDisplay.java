package y2022.m6.day30.TemplateMethod;

/**
 * @Author: leah_ana
 * @Date: 2022/6/30 08:45
 * @Desc: 只实现了display方法是的抽象类
 */

public abstract class AbstractDisplay {
    public abstract  void open();          // 交给子类实现的抽象方法(1)open
    public abstract  void print();         // 交给子类实现的抽象方法(2)print
    public abstract  void close();         // 交给子类实现的抽象方法(3)close
    public  final void display(){
        open();                            // 首先打开...
        for (int i = 0; i < 5; i++) {
            print();                       // 循环调用5次print
        }
        close();                           // 循环调用5次print
    }
}
