package y2022.m7.day18.ChainOfResponsibility;

/**
 * @Author: LeahAna
 * @Date: 2022/7/18 08:45
 * @Desc: 用来解决问题的具体类（仅解决奇数编号的问题）
 */

public class OddSupport extends Support {

    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() % 2 == 1) {
            return true;
        } else {
            return false;
        }

    }
}
