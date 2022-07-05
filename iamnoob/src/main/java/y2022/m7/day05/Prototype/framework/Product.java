package y2022.m7.day05.Prototype.framework;

/**
 * @Author: LeahAna
 * @Date: 2022/7/5 08:55
 * @Desc: 声明了抽象发放 use 和 createClone的接口
 */

public interface Product extends Cloneable {
    public abstract void user(String s);
    public abstract Product createClone();
}
