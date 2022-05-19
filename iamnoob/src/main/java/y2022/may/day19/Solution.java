package y2022.may.day19;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: leah_ana
 * @Date: 2022/5/19 22:02
 */

public class Solution {
    public static void main(String[] args) {
        int[] ints = {1, 1, 0, 0, 1, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(ints));
    }

    //485. 最大连续 1 的个数解法
    //解法1：一次遍历
    public static int findMaxConsecutiveOnes(int[] nums) {
        int temp = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                temp++;
            } else {
                temp = 0;
            }
            max = Math.max(temp, max);
        }
        return max;
    }
}
