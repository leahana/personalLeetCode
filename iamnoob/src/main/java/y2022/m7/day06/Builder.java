package y2022.m7.day06;

/**
 * @Author: LeahAna
 * @Date: 2022/7/6 08:29
 * @Desc: 定义文档结构的方法的抽象类
 */

public abstract class Builder {
    public abstract void makeTitle(String title);

    public abstract void makeString(String str);

    public abstract void makeItems(String[] items);

    public abstract void close();
}
