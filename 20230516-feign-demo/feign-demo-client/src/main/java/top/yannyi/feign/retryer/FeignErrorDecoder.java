package top.yannyi.feign.retryer;

import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import top.yannyi.feign.exception.ResourceNotFoundException;
import top.yannyi.feign.exception.TokenExpiredException;
import javax.naming.NoPermissionException;

/**
 * @Author: LeahAna
 * @Date: 2023/6/13 10:24
 * @Desc: 错误处理
 */

public class FeignErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    /**
     * 不同状态码throw不同异常
     * @param methodKey 请求方法
     * @param response 请求响应
     * @return 自定义异常
     */
    @Override
    public Exception decode(String methodKey, Response response) {
        switch (response.status()) {
            case 401:
                return new RetryableException(
                        response.status(),
                        "Token expired, refresh and retry",
                        response.request().httpMethod(),
                        new TokenExpiredException("Token expired"),
                        null,
                        response.request());
            case 403:
                return new NoPermissionException("Permission denied");
            case 404:
                return new ResourceNotFoundException("Resource not found");
            case 500:
                return new RuntimeException("System err");
            default:
                return defaultErrorDecoder.decode(methodKey, response);
        }
    }
}
