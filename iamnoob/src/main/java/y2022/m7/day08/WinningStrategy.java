package y2022.m7.day08;

import java.util.Random;

/**
 * @Author: LeahAna
 * @Date: 2022/7/8 08:31
 * @Desc: 表示如果这这局猜拳获胜，那么下一局也出一样的手势这一决策
 */

public class WinningStrategy implements Strategy {
    private Random random;
    private boolean won = false;
    private Hand prevHand;

    public WinningStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if (!won) {
            prevHand = Hand.getHand(random.nextInt(3));
        }
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}
