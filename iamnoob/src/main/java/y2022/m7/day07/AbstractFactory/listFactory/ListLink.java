package y2022.m7.day07.AbstractFactory.listFactory;

import y2022.m7.day07.AbstractFactory.factory.Link;

/**
 * @Author: LeahAna
 * @Date: 2022/7/7 08:39
 * @Desc: 具体零件：表示HTML的标签类
 */

public class ListLink extends Link {


    public ListLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return "<li><a href\""+url+"\""+caption+"</a></li>\n";
    }
}
