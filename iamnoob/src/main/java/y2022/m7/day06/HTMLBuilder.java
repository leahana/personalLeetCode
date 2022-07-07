package y2022.m7.day06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: LeahAna
 * @Date: 2022/7/6 08:31
 * @Desc: 使用HTML编写文档的类
 */

public class HTMLBuilder extends Builder {
    private String filename;                        // 文件名
    private PrintWriter writer;                     // 用于编写文件的printWrite


    @Override
    public void makeTitle(String title) {           // HTML文件的标题
        filename = title + ".html";                 // 将标题作为文件名
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        writer.println("<html><head><title>" + title + "</title><head><body>");
        writer.println("<h1>" + title + "</h1>");
    }

    @Override
    public void makeString(String str) {
        writer.println("<p>" + str + "</p>");
    }

    @Override
    public void makeItems(String[] items) {
        writer.println("<ul>");
        for (int i = 0; i < items.length; i++) {
            writer.println("<li>" + items[i] + "</li>");
        }
        writer.println("</ul>");
    }

    @Override
    public void close() {
        writer.println("</body></html>");
        writer.close();
    }

    public String getResult() {
        return filename;
    }
}
