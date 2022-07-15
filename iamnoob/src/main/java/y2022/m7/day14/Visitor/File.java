package y2022.m7.day14.Visitor;

/**
 * @Author: LeahAna
 * @Date: 2022/7/14 08:56
 * @Desc: 表示文件的类
 */

public class File extends Entry {
    private String  name;
    private int size;


    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }
}
