package y2022.m7.day07.AbstractFactory.factory;

/**
 * @Author: LeahAna
 * @Date: 2022/7/7 08:34
 * @Desc: 方便统一处理Link和Tray的类
 */

public abstract class Item {
    protected String caption;

    public Item(String caption) {
        this.caption = caption;
    }
    public  abstract String makeHTML();

    public Item() {

    }
}
