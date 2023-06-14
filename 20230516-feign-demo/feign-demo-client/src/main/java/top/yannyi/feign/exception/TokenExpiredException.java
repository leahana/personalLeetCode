package top.yannyi.feign.exception;

import feign.Request;
import feign.RetryableException;

import java.util.Date;

/**
 * @Author: LeahAna
 * @Date: 2023/6/13 09:49
 * @Desc:
 */

public class TokenExpiredException extends RuntimeException {

    public TokenExpiredException() {
    }

    public TokenExpiredException(String message) {
        super(message);
    }
}
