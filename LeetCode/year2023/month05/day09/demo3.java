package month05.day09;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 链接：https://leetcode.cn/problems/longest-increasing-subsequence
 * @date 2023/5/9 19:26
 */
public class demo3 {
    public int lengthOfLIS1(int[] nums) {
        int max = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] d = new int[length + 1];
        int len = 1;
        d[len] = nums[0];

        for (int i = 1; i < length; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                int L = 1, R = len, P = 0;
                while (L <= R) {
                    int m = (L + R) >>> 1;
                    if (d[m] < nums[i]) {
                        P = m;
                        L = m + 1;
                    } else {
                        R = m - 1;
                    }
                }
                d[P + 1] = nums[i];
            }
        }
        return len;
    }
}

