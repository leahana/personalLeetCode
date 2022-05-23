package y2022.may.day21;

/**
 * @Author: leah_ana
 * @Date: 2022/5/23 0:29
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(divisorGame(2));
    }
    //1025. 除数博弈

    public static boolean divisorGame(int n) {
        return n % 2 == 0;

    }
}
