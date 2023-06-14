package top.yannyi.feign.retryer;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: LeahAna
 * @Date: 2023/6/14 10:23
 * @Desc:
 */
@Slf4j
public class TokenRefresher {
    private final TokenService tokenService;
    private final TokenManager tokenManager;

    public TokenRefresher(TokenService tokenService, TokenManager tokenManager) {
        this.tokenService = tokenService;
        this.tokenManager = tokenManager;
    }

    public void fetchToken() {
        String token =tokenService.getToken();
        tokenManager.setToken(token);
        log.info("TokenRefresher fetchToken()...");
    }

}
