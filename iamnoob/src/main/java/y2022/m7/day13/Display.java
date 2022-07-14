package y2022.m7.day13;

/**
 * @Author: LeahAna
 * @Date: 2022/7/13 08:31
 * @Desc: 用于显示字符串的抽象类
 */

public abstract class Display {
    public abstract int getColumns();       // 获取横向字符数

    public abstract int getRows();          // 获取纵向行数

    public abstract String getRowText(int row); // 获取第row行的字符串

    public final void show(){               // 全部显示
        for (int i = 0; i < getRows(); i++) {
            System.out.println(getRowText(i));
        }
    }
 }
