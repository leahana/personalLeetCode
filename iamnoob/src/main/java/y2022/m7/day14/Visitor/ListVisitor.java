package y2022.m7.day14.Visitor;

import java.util.Iterator;

/**
 * @Author: LeahAna
 * @Date: 2022/7/14 08:54
 * @Desc: Visitor类的子类，显示文件和文件夹一览
 */

public class ListVisitor extends Visitor{
    private String currentDir = "";


    @Override
    public void visit(File file) {
        System.out.println(currentDir+"/"+file);
    }

    @Override
    public void visit(Directory directory) {
        System.out.println(currentDir+"/"+directory);
        String saveDir=currentDir;
        currentDir=currentDir+"/"+directory.getName();
        Iterator iterator = directory.iterator();
        while (iterator.hasNext()){
            Entry entry = (Entry) iterator.next();
            entry.accept(this);

        }
        currentDir = saveDir;
    }
}
