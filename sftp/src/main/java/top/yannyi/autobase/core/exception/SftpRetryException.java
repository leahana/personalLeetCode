package top.yannyi.autobase.core.exception;


/**
 * @Author: LeahAna
 * @Date: 2023/4/7 10:45
 * @Desc: 自定义重试异常
 */


public class SftpRetryException extends Exception {

    public SftpRetryException(ErrorResult errorResult) {
        super(errorResult.getErrMessage());
    }


}
