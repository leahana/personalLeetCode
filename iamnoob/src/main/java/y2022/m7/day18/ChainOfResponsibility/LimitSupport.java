package y2022.m7.day18.ChainOfResponsibility;

/**
 * @Author: LeahAna
 * @Date: 2022/7/18 08:44
 * @Desc: 用来解决问题的具体类（仅解决编号小于指定编号的问题）
 */

public class LimitSupport extends Support {
    private int limit;                              // 可以解决编号小于limit的问题

    public LimitSupport(String name, int limit) {          // 构造函数
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {// 解决问题的方法
        if (trouble.getNumber() < limit) {
            return true;
        } else {
            return false;
        }
    }
}
