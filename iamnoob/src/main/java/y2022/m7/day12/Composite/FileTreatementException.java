package y2022.m7.day12.Composite;

/**
 * @Author: LeahAna
 * @Date: 2022/7/12 08:34
 * @Desc: 表示向文件中增加Entry时发生异常的类
 */

public class FileTreatementException extends RuntimeException {
    public FileTreatementException() {
    }

    public FileTreatementException(String message) {
        super(message);
    }
}
