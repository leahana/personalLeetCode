package top.yannyi.feign.retryer;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @Author: LeahAna
 * @Date: 2023/6/13 10:03
 * @Desc: feign拦截请求 统一封装token请求头
 */

public class FeignAutoRequestInterceptor implements RequestInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";

    private static final String BEARER_TOKEN_TYPE = "Bearer: ";

    private final TokenManager tokenManager;

    public FeignAutoRequestInterceptor(TokenManager tokenManager) {
        this.tokenManager = tokenManager;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String token = tokenManager.getToken();
        requestTemplate.header(AUTHORIZATION_HEADER, token);
    }
}
