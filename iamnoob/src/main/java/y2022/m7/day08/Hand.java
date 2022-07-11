package y2022.m7.day08;

/**
 * @Author: LeahAna
 * @Date: 2022/7/8 08:29
 * @Desc: 猜拳游戏中表示手势的类
 */

public class Hand {
    public static final int HAND_VALUE_GUU = 0;  // 表示石头
    public static final int HAND_VALUE_CHO = 1;  // 表示剪刀
    public static final int HAND_VALUE_PAA = 2;  // 表示布

    public static final Hand[] hand = {     // 表示三种手势的实例
            new Hand(HAND_VALUE_GUU),
            new Hand(HAND_VALUE_CHO),
            new Hand(HAND_VALUE_PAA)
    };
    private static final String[] name = {      //猜拳中出的手势的值
            "石头", "剪刀", "布"};

    private int handValue;

    private Hand(int handValue) {
        this.handValue = handValue;             // 根据手势的值获取对应的实例
    }

    public static Hand getHand(int handValue) {         // 根据手势的值获取对应的实例
        return hand[handValue];
    }

    public boolean isStrongThan(Hand hand) {     // 如果this胜了则返回true
        return fight(hand) == 1;
    }

    public boolean isWeakerThan(Hand hand) {     // 如果this输了则返回false
        return fight(hand) == -1;
    }

    private int fight(Hand hand) {
        if (this == hand) {
            return 0;
        } else if ((this.handValue + 1) % 3 == hand.handValue) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return name[handValue];
    }
}
