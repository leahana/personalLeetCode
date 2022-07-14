package y2022.m7.day12.Composite;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: LeahAna
 * @Date: 2022/7/12 08:33
 * @Desc: 表示文件夹的类
 */

public class Directory extends Entry {
    private String name;                            // 文件夹名字
    private ArrayList directory = new ArrayList();  // 文件夹中目录条目的集合

    public Directory(String name) {                 // 构造函数
        this.name = name;
    }

    @Override
    public String getName() {                       // 获取名字
        return name;
    }

    @Override
    public int getSize() {                  // 获取大小
        int size = 0;
        Iterator iterator = directory.iterator();
        while (iterator.hasNext()) {
            Entry next = (Entry) iterator.next();
            size += next.getSize();
        }
        return size;
    }

    public Entry add(Entry entry) {         // 增加条目
        directory.add(entry);
        return this;
    }

    @Override
    protected void printList(String prefix) { // 更新目录一览
        System.out.println(prefix+"/"+this);
        Iterator iterator = directory.iterator();
        while ( iterator.hasNext()){
            Entry entry = (Entry) iterator.next();
            entry.printList(prefix+"/"+name);
        }
    }
}
