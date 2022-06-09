package y2022.m5.day20;

import java.util.Arrays;

/**
 * @Author: leah_ana
 * @Date: 2022/5/20 11:39
 */

public class Solution {
    //长度最小的子数组,滑块
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int l = 0;
        int r = 0;
        int ans = Integer.MAX_VALUE;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 移动0
    public static void moveZeroes(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            while (nums[r] == 0) {
                r--;
            }
            if (nums[l] == 0) {
                nums[l] = nums[r];
                nums[r] = 0;
            }
            l++;
        }
    }

    public static void moveZeroes2(int[] nums) {
        if (nums.length == 1) return;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] != 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            }
        }
    }


    // 回文数
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        int l = 0;
        int r = chars.length-1;
        while (l < r) {
            if (chars[l] != chars[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
