package y2022.m7.day07.Bridge;

/**
 * @Author: LeahAna
 * @Date: 2022/7/7 14:55
 * @Desc: 增加了"只显示规定次数"这一功能的类
 */

public class CountDisplay extends Display{

    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }

    public void multiDisplay(int times){  // 循环显示times次
        open();
        for (int i = 0; i < times; i++) {
            print();
        }
        close();
    }
}
