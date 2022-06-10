package y2022.m6.day10;

import java.util.Arrays;
import java.util.OptionalDouble;

/**
 * @Author: leah_ana
 * @Date: 2022/6/10 8:44
 */

public class Solution {
    //1523. 在区间范围内统计奇数数目
    // 暴力枚举超时
    public int countOdds(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (i % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    // 前缀和思想
    public int countOdds2(int low, int high) {
        return gre(high) - gre(low - 1);
    }

    private int gre(int num) {
        return (num + 1) / 2;
    }

    //1491. 去掉最低工资和最高工资后的工资平均值
    public double average(int[] salary) {
        double[] doubles = Arrays.stream(salary).mapToDouble(value -> (double) value).sorted().toArray();
        double[] nums = new double[doubles.length - 2];
        System.arraycopy(doubles, 1, nums, 0, nums.length);
        return Arrays.stream(nums).average().getAsDouble();
    }


    public double average2(int[] salary) {
            double sum = 0;
            double max = Integer.MIN_VALUE;
            double min = Integer.MAX_VALUE;
            for (int i : salary) {
                sum += i;
                max = Math.max(max, i);
                min = Math.min(min, i);
            }
            return (sum - max - min) / (salary.length - 2);
    }
}
