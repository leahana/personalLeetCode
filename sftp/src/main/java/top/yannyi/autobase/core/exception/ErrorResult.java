package top.yannyi.autobase.core.exception;

import lombok.Builder;
import lombok.Data;

/**
 * @Author: LeahAna
 * @Date: 2023/3/22 15:28
 * @Desc: 自定义异常message
 */

@Data
@Builder
public class ErrorResult {
    private String errCode = "999999";
    private String errMessage;

    public static ErrorResult connectError() {
        return ErrorResult.builder().errCode("00001").errMessage("连接服务器失败").build();
    }

    public static ErrorResult disconnectError() {
        return ErrorResult.builder().errCode("00002").errMessage("关闭服务器失败").build();
    }
}
