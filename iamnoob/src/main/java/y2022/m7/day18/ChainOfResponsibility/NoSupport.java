package y2022.m7.day18.ChainOfResponsibility;

/**
 * @Author: LeahAna
 * @Date: 2022/7/18 08:44
 * @Desc: 用来解决问题的具体类（表示"不处理问题"）
 */

public class NoSupport extends Support{

    public NoSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {        // 解决问题的方法
        return false;                                   // 自己什么都不处理
    }
}
