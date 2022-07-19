package y2022.m7.day18.ChainOfResponsibility;

/**
 * @Author: LeahAna
 * @Date: 2022/7/18 08:43
 * @Desc: 表示发生问题的类
 */

public class Trouble {

    private int number;             // 问题编号

    public Trouble(int number) {    // 生成问题
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {      //  代表问题的字符串
        return "Trouble{" +
                "number=" + number +
                '}';
    }
}
