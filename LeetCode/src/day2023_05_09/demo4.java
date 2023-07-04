package day2023_05_09;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 链接：https://leetcode.cn/problems/minimum-size-subarray-sum
 * @date 2023/5/9 20:21
 */
public class demo4 {
    public  int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;

        int l = 0;
        int r = 0;

        int sum = 0;

        while (r < nums.length) {
           sum+=nums[r];
            r++;
           while (sum >= target){
               min = Math.min(min,r-l);
               sum-=nums[l];
               l++;
           }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}

