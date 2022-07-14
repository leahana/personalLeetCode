package y2022.m7.day13;

/**
 * @Author: LeahAna
 * @Date: 2022/7/13 08:36
 * @Desc: 用于显示上下左右边框的类
 */

public class FullBorder extends Border {

    protected FullBorder(Display display) {
        super(display);
    }

    @Override
    public int getColumns() {                   // 行数为被装饰物的行数加两侧边框的行数
        return 1+display.getColumns()+1;
    }

    @Override
    public int getRows() {                      //  行数为被装饰物的行数加上上下边框的行数
        return 1+display.getRows()+1;
    }

    @Override
    public String getRowText(int row) {
        if(row==0){
            return "+" + makeLine('-', display.getColumns())+"+";       // 上边框

        }else if (row == display.getRows()+1){
            return "+"+makeLine('-',display.getColumns())+"+";          // 下边框
        }
        return "|" + display.getRowText(row - 1) + "|";                     // 其他边框
    }

    private String makeLine(char ch,int count){                             // 生成一个重复count次字符的ch的字符串
        StringBuffer buf =new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(ch);
        }
        return buf.toString();
    }

}
