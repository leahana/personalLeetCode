package y2022.m7.day08;

/**
 * @Author: LeahAna
 * @Date: 2022/7/8 08:29
 * @Desc: 猜拳游戏中策略的类
 */

public interface Strategy {
        Hand nextHand();
        void study(boolean win);
}
