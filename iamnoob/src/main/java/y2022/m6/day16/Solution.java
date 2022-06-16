package y2022.m6.day16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: leah_ana
 * @Date: 2022/6/16 08:45
 */

public class Solution {
    // 350. 两个数组的交集 II  hash表
    public int[] intersect(int[] nums1, int[] nums2) {
        // 递归处理 保证第一个数组的长度比第二个数组小
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        //getOrDefault(Object key, V defaultValue)
        //意思就是当Map集合中有这个key时，就使用这个key对应的value值，如果没有就使用默认值defaultValue
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            int count = map.getOrDefault(i, 0) + 1;
            map.put(i, count);
        }
        int[] nums = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                nums[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else map.remove(num);
            }
        }
        return Arrays.copyOfRange(nums,0,index);
    }
}
