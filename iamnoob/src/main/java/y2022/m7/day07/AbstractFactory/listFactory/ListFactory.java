package y2022.m7.day07.AbstractFactory.listFactory;

import y2022.m7.day07.AbstractFactory.factory.Factory;
import y2022.m7.day07.AbstractFactory.factory.Link;
import y2022.m7.day07.AbstractFactory.factory.Page;
import y2022.m7.day07.AbstractFactory.factory.Tray;

/**
 * @Author: LeahAna
 * @Date: 2022/7/7 08:38
 * @Desc: 表示具体工厂的类（制作ListLink  ListTray ListPage）
 */

public class ListFactory extends Factory {

    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption,url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title,author);
    }
}
