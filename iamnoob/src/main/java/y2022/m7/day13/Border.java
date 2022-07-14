package y2022.m7.day13;

/**
 * @Author: LeahAna
 * @Date: 2022/7/13 08:32
 * @Desc: 用于装饰边框的抽象类
 */

public abstract class Border extends Display {
    protected Display display;          // 表示被装饰物

    protected Border(Display display) { // 在生成实例时通过参数指定被装饰物
        this.display = display;
    }
}
