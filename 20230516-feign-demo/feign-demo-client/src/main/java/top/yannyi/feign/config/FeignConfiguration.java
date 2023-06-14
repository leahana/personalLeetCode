package top.yannyi.feign.config;

import feign.Logger;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.yannyi.feign.client.HelloClient;
import top.yannyi.feign.retryer.FeignAutoRequestInterceptor;
import top.yannyi.feign.retryer.FeignErrorDecoder;
import top.yannyi.feign.retryer.FeignRetryer;
import top.yannyi.feign.retryer.TokenManager;
import top.yannyi.feign.retryer.TokenRefresher;
import top.yannyi.feign.retryer.TokenService;

/**
 * @Author: LeahAna
 * @Date: 2023/6/13 10:44
 * @Desc:
 */

@Configuration
public class FeignConfiguration {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public TokenManager tokenManager() {
        return new TokenManager();
    }




    @Bean
    public TokenService tokenService(ObjectProvider<HelloClient> helloClientObjectProvider) {
        return new TokenService(helloClientObjectProvider);
    }

    @Bean
    public TokenRefresher tokenRefresher(TokenService tokenService, TokenManager tokenManager) {
        return new TokenRefresher(tokenService, tokenManager);
    }

    @Bean
    public Retryer feignRetryer(TokenRefresher tokenRefresher) {
        return new FeignRetryer(tokenRefresher);
    }

    @Bean
    public FeignAutoRequestInterceptor feignAutoRequestInterceptor(TokenManager tokenManager) {
        return new FeignAutoRequestInterceptor(tokenManager);
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignErrorDecoder();
    }


}
