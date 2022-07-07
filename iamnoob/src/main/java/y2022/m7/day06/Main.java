package y2022.m7.day06;

import java.io.FilterOutputStream;


/**
 * @Author: LeahAna
 * @Date: 2022/7/6 08:28
 * @Desc: 测试程序运行的类
 */

public class Main {
    public static void main(String[] args) {
    /*    System.out.println(args.length);
        if (args.length!=1){
            usage();
            System.exit(0);
        }*/
/*
        if (args[0].equals("plain")){
*//*
            TextBuilder textBuilder=new TextBuilder();
            Director director=new Director(textBuilder);
            director.construct();;
            String result= textBuilder.getResult();
            System.out.println(result);*/
/*
        }else if(args[0].equals("html")){
*/
            HTMLBuilder htmlBuilder=new HTMLBuilder();
            Director director= new Director(htmlBuilder);
            director.construct();
            String filename=htmlBuilder.getResult();
            System.out.println(filename+"文件编写完成");
  /*      }else {
            usage();
            System.exit(0);
        }*/
    }
  /*  public static void usage(){
        System.out.println("Usage: java Main plain    编写纯文本文档");
        System.out.println("Usage: java Main html     编写纯文本文档");
    }*/
}
