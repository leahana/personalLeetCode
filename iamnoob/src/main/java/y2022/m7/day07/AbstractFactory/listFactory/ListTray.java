package y2022.m7.day07.AbstractFactory.listFactory;

import y2022.m7.day07.AbstractFactory.factory.Item;
import y2022.m7.day07.AbstractFactory.factory.Tray;

import java.util.Iterator;

/**
 * @Author: LeahAna
 * @Date: 2022/7/7 08:40
 * @Desc: 具体零件： 表示含有Link和Tray的类
 */

public class ListTray extends Tray {

    public ListTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("<li>\n");
        buffer.append(caption + "\n");
        buffer.append("<ul>\n");
        Iterator iterator = tray.iterator();
        while (iterator.hasNext()){
            Item item=(Item)iterator.next() ;
            buffer.append(item.makeHTML());
        }
        buffer.append("</ul>\n");
        buffer.append("</li>\n");
        return buffer.toString();
    }
}
