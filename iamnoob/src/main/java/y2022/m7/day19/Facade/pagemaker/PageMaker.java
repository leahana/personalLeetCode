package y2022.m7.day19.Facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author: LeahAna
 * @Date: 2022/7/19 08:36
 * @Desc: 根据邮件地址编写用户的Web页面的类
 */

public class PageMaker {
    private PageMaker pageMaker;
    public static  void makeWelcomePage(String  mailaddr,String filename){
        try {
            Properties mailProp=Database.getProperties("/Users/anshengyo/WorkSpace/IdeaProjects/JavaProject/github/personalLeetCode/iamnoob/src/main/java/y2022/m7/day19/maildata");
            String name = mailProp.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));

            writer.title("welcome"+name+"'s page !");
            writer.paragraph(name+"欢迎来到"+name+"的主页");
            writer.paragraph("等着你的邮件");
            writer.mailto(mailaddr,name);
            writer.close();
            System.out.println(filename+"is created for"+mailaddr+"("+name+")");

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
