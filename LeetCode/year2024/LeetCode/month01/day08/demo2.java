package LeetCode.month01.day08;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/7 14:55
 */
public class demo2 {
    int mod = (int) 1e9 + 7;

    public int numRollsToTarget(int n, int k, int target) {
        if (target < n || target > n * k) {
            return 0;
        }
        long[] dp = new long[k + 1];
        Arrays.fill(dp, 1);
        for (int a = 2; a <= n; a++) {
            long[] new_dp = new long[a * k + 1];
            for (int b = a - 1; b <= (a - 1) * k; b++) {
                for (int c = 1; c <= k; c++) {
                    new_dp[b + c] = (new_dp[b + c] + dp[b]) % mod;
                }
            }
            dp = new_dp;
        }
        return (int) dp[target + 1];
    }

    public int numRollsToTarget1(int n, int m, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= target; j++) {
                for (int k = 1; k <= m; k++) {
                    if (k <= j) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
                    }
                }
            }
        }
        return dp[n][target];
    }
}

