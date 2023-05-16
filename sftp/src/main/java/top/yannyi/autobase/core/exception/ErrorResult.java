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
        return ErrorResult.builder().errCode("00001").errMessage("开启sftp服务器连接失败").build();
    }

    public static ErrorResult disconnectError() {
        return ErrorResult.builder().errCode("00002").errMessage("关闭sftp服务器连接失败").build();
    }

    public static ErrorResult uploadError() {
        return ErrorResult.builder().errCode("00003").errMessage("上传文件失败").build();
    }

    public static ErrorResult downloadError() {
        return ErrorResult.builder().errCode("00004").errMessage("下载文件失败").build();
    }

    public static ErrorResult deleteError() {
        return ErrorResult.builder().errCode("00004").errMessage("删除文件失败").build();
    }
}
