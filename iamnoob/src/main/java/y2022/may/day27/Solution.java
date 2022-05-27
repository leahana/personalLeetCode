package y2022.may.day27;

/**
 * @Author: leah_ana
 * @Date: 2022/5/27 8:47
 */

public class Solution {
    public static void main(String[] args) {
        int a = 11;
        int b = 22;
        int mid = (a + b) / 2;
        int anMid = a + (b - a) / 2;

        System.out.println(mid);
        System.out.println(anMid);
    }

    // 704: 二分查找
    public static int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) return 0;
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 第一个错误的版本
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
//            if(isBadVersion(mid)){
//                if (left==right ) break;
//                right=mid;
//            }else{
            //区间从mid +1开始
//                left=mid+1;
//            }

        }
        return left;
    }

    // 35. 搜索插入位置
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // target比mid大 说明在mid 右边
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }
}

