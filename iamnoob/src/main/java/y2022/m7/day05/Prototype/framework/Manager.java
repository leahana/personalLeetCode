package y2022.m7.day05.Prototype.framework;

import java.util.HashMap;


/**
 * @Author: LeahAna
 * @Date: 2022/7/5 08:56
 * @Desc: 调用createClone 方法复制实例的类
 */

public class Manager {
    private HashMap showcase=new HashMap<>();

    public void register(String name ,Product proto){
        showcase.put(name,proto);
    }

    public Product createClone(String protoName){
        Product p =(Product) showcase.get(protoName);
        return p.createClone();
    }
}
