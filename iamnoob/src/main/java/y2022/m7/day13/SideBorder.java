package y2022.m7.day13;

/**
 * @Author: LeahAna
 * @Date: 2022/7/13 08:34
 * @Desc: 用于只显示左右边框装饰的类
 */

public class SideBorder extends Border {
    private char borderChar;                                    // 表示被装饰的字符

    protected SideBorder(Display display, char borderChar) {    // 通过构造函数
        super(display);                                         // 指定Display和装饰边框字符
        this.borderChar = borderChar;
    }

    @Override
    public int getColumns() {                                   // 字符数为字符串字字符数
        return 1 + display.getColumns() + 1;                    // 加上两侧边框字符数
    }

    @Override
    public int getRows() {                                      // 行数即被装饰的行数
        return display.getRows();
    }

    @Override
    public String getRowText(int row) {                         // 指定哪一行的字符串被装饰物的字符串
        return borderChar+display.getRowText(row)+borderChar;                                            // 加上两侧边框的字符
    }
}
