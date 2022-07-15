package y2022.m7.day12.Composite;

import y2022.m7.day07.Bridge.Display;

/**
 * @Author: LeahAna
 * @Date: 2022/7/12 08:35
 * @Desc: 测试方法运行的类
 */

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("making root entries...");
            Directory rootdir = new Directory("root");
            Directory bindir = new Directory("bin");
            Directory tmpdir = new Directory("tmp");
            Directory usrdir = new Directory("usr");

            rootdir.add(bindir);
            rootdir.add(tmpdir);
            rootdir.add(usrdir);
            bindir.add(new File("vi", 10000));
            bindir.add(new File("latex", 20000));
            rootdir.printList();

            System.out.println("");
            System.out.println("making user entries...");
            Directory yuki = new Directory("yuki");
            Directory hanako = new Directory("hanako");
            Directory tumura = new Directory("tumura");
            usrdir.add(yuki);
            usrdir.add(hanako);
            usrdir.add(tmpdir);

            yuki.add(new File("diary.html", 100));
            yuki.add(new File("Composite.java", 200));

            hanako.add(new File("memo.tx", 300));
            tumura.add(new File("game.doc", 400));
            tumura.add(new File("junk.mail", 500));
            rootdir.printList();

        } catch (FileTreatementException e) {
            e.printStackTrace();
        }

    }
}
