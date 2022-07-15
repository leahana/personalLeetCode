package y2022.m7.day14.Visitor;

/**
 * @Author: LeahAna
 * @Date: 2022/7/14 08:53
 * @Desc: 表示访问者的抽象类， 他访问文件和文件夹
 */

public abstract class Visitor {
        public abstract void visit(File file);

    public abstract void visit(Directory directory);
}
