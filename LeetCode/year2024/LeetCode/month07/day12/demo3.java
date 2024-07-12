package LeetCode.month07.day12;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/12 9:41
 */
public class demo3 {
    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > n * k) return 0;
        int mod = 1000000007;
        long[] dp = new long[k + 1];
        Arrays.fill(dp, 1L);
        for (int i = 2; i <= n; i++) {
            long[] new_dp = new long[i * k + 1];
            for (int j = i - 1; j < (i - 1) * k + 1; j++) {
                for (int l = 1; l <= k; l++) {
                    new_dp[j + l] = (new_dp[j + l] + dp[j]) % mod;
                }
            }
            dp = new_dp;
        }
        return (int) dp[target];
    }
}

