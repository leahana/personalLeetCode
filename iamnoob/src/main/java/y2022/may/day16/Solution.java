package y2022.may.day16;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    //双指针，反转字符串
    public void reverseString(char[] s) {
        if (s.length <= 1) {
            return;
        }
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    //双指针，数组拆分
    public int arrayPairSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int[] ints = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < nums.length; i += 2) {
            sum += ints[i];
        }
        return sum;
    }
}