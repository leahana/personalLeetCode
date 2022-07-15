package y2022.m7.day14.Visitor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: LeahAna
 * @Date: 2022/7/14 08:56
 * @Desc: 表示文件夹的类
 */

public class Directory extends Entry{
    private String name;
    private ArrayList dir = new ArrayList();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public Entry add(Entry entry) throws FileTreatementException {
        dir.add(entry);
        return this;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

    }

    public Iterator iterator(){
        return dir.iterator();
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size=0;
        Iterator iterator = dir.iterator();
        while (iterator.hasNext()){
            Entry entry=(Entry) iterator.next();
            size+=entry.getSize();
        }
        return size;
    }
}
