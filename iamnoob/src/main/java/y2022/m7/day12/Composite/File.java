package y2022.m7.day12.Composite;

/**
 * @Author: LeahAna
 * @Date: 2022/7/12 08:32
 * @Desc: 表示文件的类
 */

public class File extends Entry{
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix+"/"+this);
    }
}
