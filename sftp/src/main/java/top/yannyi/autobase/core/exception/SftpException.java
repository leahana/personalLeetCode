package top.yannyi.autobase.core.exception;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;




/**
 * @Author: LeahAna
 * @Date: 2023/3/22 15:27
 * @Desc: 自定义Sftp异常
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class SftpException extends RuntimeException {

    private ErrorResult errorResult;

    public SftpException(ErrorResult errorResult) {
        super(errorResult.getErrMessage());
        this.errorResult = errorResult;
    }
}
