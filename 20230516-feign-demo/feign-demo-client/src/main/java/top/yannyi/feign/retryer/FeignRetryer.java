package top.yannyi.feign.retryer;

import feign.RetryableException;
import feign.Retryer;
import lombok.extern.slf4j.Slf4j;
import top.yannyi.feign.exception.TokenExpiredException;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: LeahAna
 * @Date: 2023/6/13 09:44
 * @Desc: feign 重试逻辑
 */

@Slf4j
public class FeignRetryer implements Retryer {

    public final static int MAX_ATTEMPTS = 3;
    private final static AtomicInteger retryCount = new AtomicInteger(0);

    private final TokenRefresher tokenRefresher;

    public FeignRetryer(TokenRefresher tokenRefresher) {
        this.tokenRefresher = tokenRefresher;
    }

    /**
     * @param e
     */
    @Override
    public void continueOrPropagate(RetryableException e) {
            if (retryCount.getAndIncrement() < MAX_ATTEMPTS) {
                if (e.getCause() instanceof TokenExpiredException) {
                    refreshTokenAndThrows();
                }
                // 记录重试的请求
                log.info("Retrying request. Attempt number: {}, Method: {}, URL: {}, Error: {}",
                        retryCount,
                        e.request().httpMethod(),
                        e.request().url(),
                        e.getMessage());
            } else {
                // 重试次数大于3
                retryCount.set(0);
                throw new NonRetryableException("Feign retry all count > 3");
            }

    }

    private void refreshTokenAndThrows() throws RetryableException {
        tokenRefresher.fetchToken();
    }


    @Override
    public Retryer clone() {
        return new FeignRetryer(tokenRefresher);
    }

}
