package LeetCode.month07.day08;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/8 9:22
 */
public class demo1 {
    public long countAlternatingSubarrays(int[] nums) {
        int len = nums.length;
        long res = 1;
        long[] dp = new long[len];
        Arrays.fill(dp, 1L);
        for (int i = 1; i < len; i++) {
            if (nums[i] != nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            res += dp[i];
        }
        return res;
    }
}

