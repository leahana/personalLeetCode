package y2022.m7.day12.Composite;

import java.nio.file.spi.FileTypeDetector;

/**
 * @Author: LeahAna
 * @Date: 2022/7/12 08:32
 * @Desc: 抽象类，用来实现File类和Directory类的一致性
 */

public abstract class Entry {

    public abstract String getName();       // 获取名字

    public abstract int getSize ();         // 获取大小

    public Entry add(Entry entry) throws  FileTreatementException{ // 加入目录条目
        throw  new FileTreatementException();
    }

    public void printList(){       // 显示目录条目一览
        printList("");
    }

    protected abstract void printList(String prefix); // 为一览加上前缀并显示目录条目一览

    public String  toString (){             // 显示代表类的文字
        return getName() + "(" + getSize() + ")";
    }
}
