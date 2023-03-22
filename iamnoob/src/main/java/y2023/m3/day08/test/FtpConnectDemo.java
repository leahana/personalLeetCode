package y2023.m3.day08.test;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import java.io.IOException;

/**
 * @Author: LeahAna
 * @Date: 2023/3/8 09:47
 * @Desc:
 */
@Slf4j
public class FtpConnectDemo {
        FTPClient f = null;
        //默认构造函数
        public FtpConnectDemo(String url, String username, String password) {
            f = new FTPClient();
            //得到连接
            this.get_connection(url, username, password);
        }
        //连接服务器方法
        public void get_connection(String url, String username, String password) {
            try {
                // 设置连接超时时间
                f.setConnectTimeout(60 * 60 * 1000);
                // 设置数据超时时间
                f.enterLocalPassiveMode();
                f.setRemoteVerificationEnabled(false);
//            f.setDataTimeout(60 * 60 * 1000);
                // socket连接，设置socket连接超时时间
//            f.setSoTimeout(60 * 60 * 1000);
                //连接指定服务器，默认端口为21
                f.connect(url);
                log.info("connect success!");
                //设置链接编码，windows主机UTF-8会乱码，需要使用GBK或gb2312编码
                f.setControlEncoding("UTF-8");
                //登录
                boolean login = f.login(username, password);
                if (login)
                    log.info("登录成功!");
                else
                    log.info("登录失败！");
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        public void close_connection() {
            boolean logout = false;
            try {
                logout = f.logout();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            if (logout) {
                log.info("注销成功!");
            } else {
                log.info("注销失败!");
            }
            if (f.isConnected())
                try {
                    log.info("关闭连接！");
                    f.disconnect();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
        }

}

