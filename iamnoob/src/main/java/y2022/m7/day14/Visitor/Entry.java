package y2022.m7.day14.Visitor;

import java.util.Iterator;

/**
 * @Author: LeahAna
 * @Date: 2022/7/14 08:55
 * @Desc: File类和Directory的父类，抽象类，实现了Element接口
 */

public abstract class Entry implements Element {
    public abstract String getName();

    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatementException{

        throw new FileTreatementException();
    }
    public Iterator iterator() throws FileTreatementException{
        throw new FileTreatementException();
    }

    public String toString (){
        return getName() + "("+getSize()+")";
    }
}
