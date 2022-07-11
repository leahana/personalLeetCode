package y2022.m7.day08;

/**
 * @Author: LeahAna
 * @Date: 2022/7/8 08:33
 * @Desc: 表示进行猜拳游戏的选手的类
 */

public class Player {
    private String name;
    private Strategy strategy;
    private  int windCount;
    private  int loseCount;
    private  int gameCount;

    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public Hand nextHand(){
        return  strategy.nextHand();
    }

    public void win(){
        strategy.study(true);
        windCount++;
        gameCount++;
    }
    public void lose(){
        strategy.study(false);
        loseCount++;
        gameCount++;
    }

    public void even(){
        gameCount++;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", strategy=" + strategy +
                ", windCount=" + windCount +
                ", loseCount=" + loseCount +
                ", gameCount=" + gameCount +
                '}';
    }
}
