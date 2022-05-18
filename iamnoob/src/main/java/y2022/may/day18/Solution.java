package y2022.may.day18;

import java.util.Arrays;

/**
 * @Author: leah_ana
 * @Date: 2022/5/18 20:09
 */
public class Solution {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));
    }

    //两数之和 II - 输入有序数组
    // 双指针
    public static int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum < target) {
                ++l;
            } else {
                --r;
            }
        }
        return new int[]{-1, -1};
    }

    //移除元素  双指针 快慢指针
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = 0;
        for (; r < nums.length; r++) {
            if (nums[r] != val) {
                nums[l] = nums[r];
                l++;
            }
        }
        return l;
    }

    public int removeElement2(int[] nums, int val) {
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == val) {
                continue;
            }
            nums[l] = nums[r];
            l++;
        }
        return l;
    }
}
