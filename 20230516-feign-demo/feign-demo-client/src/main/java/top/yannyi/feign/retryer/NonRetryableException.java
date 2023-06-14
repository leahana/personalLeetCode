package top.yannyi.feign.retryer;

/**
 * @Author: LeahAna
 * @Date: 2023/6/13 10:30
 * @Desc:
 */

public class NonRetryableException extends RuntimeException {

    public NonRetryableException(String message) {
        super(message);
    }
}
