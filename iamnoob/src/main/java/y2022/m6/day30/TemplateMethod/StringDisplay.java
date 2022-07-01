package y2022.m6.day30.TemplateMethod;

/**
 * @Author: leah_ana
 * @Date: 2022/6/30 08:47
 * @Desc: 实现了open、print、close的类
 */
public class StringDisplay extends AbstractDisplay{                        // StringDisplay 也是AbstractDisplay的子类

    private String string;                          // 要显示的字符串

    private int width;                              // 以字节单位计算出字符串长度

    public StringDisplay(String string) {           // 构造函数接收的字符串被保存在字段中
        this.string = string;                       // 同时将字符串的长度保存在字段中方便后期使用
        this.width = string.getBytes().length;      //
    }

    public void open(){                             // 重写open方法
        printLine();                                // 调用该类的printLine方法划线
    }

    public void print(){                            // print方法
        System.out.println("|"+string+"|");         // 给保存在字段中的字符串前后分别加上"｜"并显示出来
    }

    public void close(){                            // close方法与open方法一样，调用printLine 方法划线
        printLine();
    }

    private void printLine(){                       // 被open 和close 方法调用 由于修饰符是private所以只能
                                                    // 本类调用

        System.out.print("+");                      // 方框左上角的"+"

        for (int i = 0; i < width; i++) {           // 显示width个的"-"
            System.out.print("-");                  // 组成方框的边框
        }
        System.out.println("+");                    // 显示方框的角"+"
    }
}
