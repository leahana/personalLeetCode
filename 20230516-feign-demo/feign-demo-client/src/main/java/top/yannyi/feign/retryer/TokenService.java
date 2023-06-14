package top.yannyi.feign.retryer;

import org.springframework.beans.factory.ObjectProvider;
import top.yannyi.feign.client.HelloClient;


/**
 * @Author: LeahAna
 * @Date: 2023/6/13 15:27
 * @Desc: token获取服务
 */

public class TokenService {

    private HelloClient helloClient;

    private final ObjectProvider<HelloClient> helloClientObjectProvider;


    public TokenService(ObjectProvider<HelloClient> helloClientObjectProvider) {
        this.helloClientObjectProvider = helloClientObjectProvider;
    }

    public String getToken() {

        return getHelloClient().getToken();
    }

    private HelloClient getHelloClient() {
        if (helloClient == null) {
            this.helloClient = helloClientObjectProvider.getIfAvailable();
        }
        return helloClient;
    }
}
