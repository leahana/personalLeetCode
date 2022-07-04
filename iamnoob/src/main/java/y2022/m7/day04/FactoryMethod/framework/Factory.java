package y2022.m7.day04.FactoryMethod.framework;

/**
 * @Author: LeahAna
 * @Date: 2022/7/4 08:34
 * @Desc: 实现了create 方法的抽象类
 */

public abstract class Factory {

    public final Product create(String owner){
        Product p= createProduct(owner);
        registerProduct(p);
        return p;
    }

    protected abstract void registerProduct(Product p) ;

    protected abstract Product createProduct(String owner) ;

}
