package y2022.m7.day08;

/**
 * @Author: LeahAna
 * @Date: 2022/7/8 08:33
 * @Desc: 测试方法运行的类
 */

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Taro",new WinningStrategy(315));
        Player p2=new Player("Hana",new ProbStrategy(15));
        for (int i = 0; i < 10000; i++) {
            Hand nextHand1=p1.nextHand();
            Hand nextHand2=p2.nextHand();
            if (nextHand1.isStrongThan(nextHand2)){
                System.out.println("Winner:"+p1);
                p1.win();
                p2.lose();
            }else if(nextHand2.isStrongThan(nextHand1)){
                System.out.println("Winner:"+p2);
                p2.win();
                p1.lose();
            }else {
                System.out.println("Even...");
                p1.even();
                p2.even();
            }
            System.out.println("Total result:");
            System.out.println(p1.toString());
            System.out.println(p2.toString());
        }
    }
}
