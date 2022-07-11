package y2022.m7.day08;

import java.util.Random;

/**
 * @Author: LeahAna
 * @Date: 2022/7/8 08:32
 * @Desc: 表示 根据上一局的手势从概率上计算出下一局的手势从之前的猜拳结果计算下一局出各种拳的概率 这一策略的类
 */

public class ProbStrategy  implements Strategy{
    private Random random;
    private int prevHandValue;
    private int currentHandValue;
    private int[][] history = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
    };

    public ProbStrategy(int seed) {
        random = new Random(seed);
    }

    public Hand nextHand() {
        int bet = random.nextInt(getSum(currentHandValue));
        int handValue = 0;
        if (bet < history[currentHandValue][0]) {
            handValue = 0;
        } else if (bet < history[currentHandValue][0] + history[currentHandValue][1]){
            handValue = 1;
        }else{
            handValue = 2;
        }prevHandValue=currentHandValue;
        currentHandValue=handValue;
        return  Hand.getHand(handValue);
    }

    private int getSum(int hv) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += history[hv][i];
        }
        return sum;
    }

    public void study(boolean win){
        if (win){
            history[prevHandValue][currentHandValue]++;
        }else {
            history[prevHandValue][(currentHandValue+1)%3]++;
            history[prevHandValue][(currentHandValue+2)%3]++;
        }
    }
}
