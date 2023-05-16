package top.yannyi.autobase.core.exception;

/**
 * @Author: LeahAna
 * @Date: 2023/4/7 11:01
 * @Desc: 连接池自定义异常
 */

public class SftpPoolException extends Exception {
    public SftpPoolException(ErrorResult errorResult) {
        super(errorResult.getErrMessage());
    }
}
