package y2022.m7.day07.AbstractFactory.factory;

/**
 * @Author: LeahAna
 * @Date: 2022/7/7 08:33
 * @Desc: 表明抽象工厂的类 （制作Link Tray Page）
 */

public abstract class Factory {
    public static Factory getFactory(String classname) {
        Factory factory = null;
        try {
            factory = (Factory) Class.forName(classname).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("没有找到" + classname + "类");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return factory;
    }

    public abstract Link createLink(String caption, String url);

    public abstract Tray createTray(String caption);

    public abstract Page createPage(String title,String author);
}
