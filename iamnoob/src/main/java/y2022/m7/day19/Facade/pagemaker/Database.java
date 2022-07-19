package y2022.m7.day19.Facade.pagemaker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author: LeahAna
 * @Date: 2022/7/19 08:36
 * @Desc: 从邮件地址获取用户名的类
 */

public class Database {
    private Database(){}

    public static Properties getProperties(String dbname){
        String filename = dbname + ".txt";
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(filename));
        } catch (IOException e) {
            System.err.println("error:"+filename+" is not found,");
        }
        return properties;

    }
}
