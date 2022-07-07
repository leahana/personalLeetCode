package y2022.m7.day07.AbstractFactory;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import y2022.m7.day07.AbstractFactory.factory.Factory;
import y2022.m7.day07.AbstractFactory.factory.Link;
import y2022.m7.day07.AbstractFactory.factory.Page;
import y2022.m7.day07.AbstractFactory.factory.Tray;
import y2022.m7.day07.AbstractFactory.listFactory.ListFactory;

/**
 * @Author: LeahAna
 * @Date: 2022/7/7 08:38
 * @Desc: 测试程序运行的类
 */

public class Main {
    public static void main(String[] args) {
    /*    if (args.length!=1){
            System.out.println("Usage: java Main class.name.of.ConcreteFactory");
            System.out.println("Example 1: java Main listFactory.ListFactory");
            System.out.println("Example 2: java Main tableFactory.TableFactory");
            System.exit(0);
        }*/

        Factory factory=Factory.getFactory("y2022.m7.day07.AbstractFactory.listFactory.ListFactory");
        Link people = factory.createLink("人民日报", "http://www.people.com.cn/");
        Link gmw = factory.createLink("光明日报", "http://www.gmw.cn/");
        Link us_yahoo = factory.createLink("yahoo!", "http://www.yahoo.com/");
        Link jp_yahoo = factory.createLink("yahoo!Japan", "http://www.yahoo.co.jp/");
        Link excite= factory.createLink("Excite","http://www.excite.com/");
        Link google = factory.createLink("Google", "http://www.google.com/");

        Tray traynews=factory.createTray("日报");
        traynews.add(people);
        traynews.add(gmw);

        Tray trayyahoo=factory.createTray("Yahoo!");
        trayyahoo.add(us_yahoo);
        trayyahoo.add(jp_yahoo);

        Tray traysearch = factory.createTray("搜索引擎");
        traysearch.add(excite);
        traysearch.add(google);
        Page page  =factory.createPage("LinkPage","小小难顶");
        page.add(traynews);
        page.add(traysearch);
        page.output();

    }
}
