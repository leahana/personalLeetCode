package y2022.m6.day30.TemplateMethod;

/**
 * @Author: leah_ana
 * @Date: 2022/6/30 08:46
 * @Desc: 实现了 open、print、close 方法的类
 */

public class CharDisplay extends AbstractDisplay{

    private char aChar;                 // 需要显示的字符

    public CharDisplay(char aChar) {    // 构造函数中接收的字符被保存在字段中
        this.aChar = aChar;
    }

    @Override
    public void open() {                // open在夫类中是抽象方法，此处重写该方法
        System.out.println("<<");       // 显示开始字符"<<"
    }

    @Override
    public void print() {               // 同样的，此处重写print方法
                                        // 该方法会在display中被重复调用
        System.out.println(aChar);      // 显示被保存在字段aChar中的字符

    }

    @Override
    public void close() {               // 同样的，此处重写close方法
        System.out.println(">>");       // 显示结束字符">>"
    }

}
