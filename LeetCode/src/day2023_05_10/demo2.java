package day2023_05_10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/search-in-rotated-sorted-array/
 * @date 2023/5/10 16:11
 */
public class demo2 {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;

        while (i <= j) {
//            判断边界值
            if (nums[i] == target) return i;
            if (nums[j]== target) return j;
            int m = i  + (j-i) /2;

            if (nums[m] == target) {
                return m;
            }

            if (nums[m] > nums[i]) {
//                前半段有序
                if (target < nums[m] && target >= nums[i]) {
//                    在前半段
                    j = m - 1;
                } else {
//                    在后半段
                    i = m + 1;
                }
            } else {
//                后半段有序
                if (target > nums[m] && target <= nums[j]) {
//                    在后半段
                    i = m + 1;
                } else {
//                    在前半段
                    j = m - 1;
                }
            }
        }
        return -1;
    }

}

