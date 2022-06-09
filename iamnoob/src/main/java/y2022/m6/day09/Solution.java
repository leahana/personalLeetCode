package y2022.m6.day09;

import java.util.Arrays;

/**
 * @Author: leah_ana
 * @Date: 2022/6/9 8:52
 */

public class Solution {
    //	#977 有序数组的平方
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public int[] sortedSquares2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            nums[i] = nums[i] * nums[i];
        }
        return nums;
    }
}
