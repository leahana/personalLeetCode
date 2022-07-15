package y2022.m7.day14.Visitor;

/**
 * @Author: LeahAna
 * @Date: 2022/7/14 08:57
 * @Desc: 表示向文件中add事发生的异常的类
 */

public class FileTreatementException extends RuntimeException {
    public FileTreatementException() {
    }

    public FileTreatementException(String message){
        super(message);
    }

}
