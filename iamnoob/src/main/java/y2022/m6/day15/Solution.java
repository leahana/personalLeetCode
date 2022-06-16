package y2022.m6.day15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author: leah_ana
 * @Date: 2022/6/15 13:03
 */

public class Solution {


    //1. 两数之和  method 1  暴力枚举
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                if (nums[i]+nums[j]==target)return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
    // method 2
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
    // 88. 合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[n+i]=nums2[i];
        }
        Arrays.sort(nums1);
    }

}
