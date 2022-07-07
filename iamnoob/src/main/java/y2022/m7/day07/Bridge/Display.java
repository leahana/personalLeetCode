package y2022.m7.day07.Bridge;

/**
 * @Author: LeahAna
 * @Date: 2022/7/7 14:54
 * @Desc: 负责显示的类
 */

public class Display {
    private DisplayImpl impl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    public void open() {
        impl.rawOpen();
    }
    public void print(){
        impl.rawPrint();
    }
    public void close(){
        impl.rawClose();
    }

    public final void display() {
        open();
        print();
        close();
    }
}
