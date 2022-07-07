package y2022.m7.day07.AbstractFactory.factory;

import java.util.ArrayList;

/**
 * @Author: LeahAna
 * @Date: 2022/7/7 08:36
 * @Desc: 抽象零件： 表示含有Link和Tray的类
 */

public abstract  class Tray extends Item{
    protected ArrayList tray = new ArrayList();

    public Tray (String caption){
        super(caption);
    }

    public void add(Item item){
        tray.add(item);
    }
}
