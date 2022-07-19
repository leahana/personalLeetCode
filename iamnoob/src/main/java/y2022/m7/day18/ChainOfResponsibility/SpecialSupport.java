package y2022.m7.day18.ChainOfResponsibility;

/**
 * @Author: LeahAna
 * @Date: 2022/7/18 08:46
 * @Desc: 用来解决问题的具体类（仅解决指定编号的问题）
 */

public class SpecialSupport extends Support {
    private int number;

    public SpecialSupport(String name,int number) {
        super(name);
        this.number=number;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber()==number){
            return true;
        }else{
            return false;
        }
    }
}
