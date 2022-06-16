package y2022.m6.day14;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: leah_ana
 * @Date: 2022/6/14 09:05
 */

public class Solution {
    // 2235. 两整数相加
    public int sum(int num1, int num2) {
        return Math.addExact(num1,num2);
    }

    //13. 罗马数字转整数
    Map<Character,Integer> map  = new HashMap<Character,Integer>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        int n=s.length();
        for (int i = 0; i < n; ++i) {

        }
        return 0;
    }
}
