package y2022.m7.day13;

/**
 * @Author: LeahAna
 * @Date: 2022/7/13 08:32
 * @Desc: 用于显示单行字符串的类
 */

public class StringDisplay  extends Display{
    private String string;                  // 要显示的字符串

    public StringDisplay(String string) {   // 通过参数传入要显示的字符串
        this.string = string;
    }

    @Override
    public int getColumns() {               // 字符数
        return string.getBytes().length;
    }

    @Override
    public int getRows() {                  // 行数是1
        return 1;
    }

    @Override
    public String getRowText(int row) {
        if (row==0){
            return string;
        }else {
            return null;
        }
    }
}
