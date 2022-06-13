package y2022.m6.day13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: leah_ana
 * @Date: 2022/6/12 23:54
 */

public class Solution {


    public static void main(String[] args) {

    }

    // 217. 存在重复元素  method 1 hash表
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num))
                return true;
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }

    //53. 最大子数组和
    // method 1 ： 动态规划  公式：    f(i)=max{f(i−1)+nums[i],nums[i]}
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxAns =nums[0];

        for (int x : nums) {
            pre = Math.max(pre+x,x);
            maxAns=Math.max(maxAns,pre);
        }
        return maxAns;
    }



}
