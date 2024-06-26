package LeetCode.month06.day26;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/26 10:44
 */
public class demo8 {
    public int waysToStep(int n) {
        if (n < 3) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int mod = 1000000007;
        for (int i = 4; i <= n; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % mod + dp[i - 3]) % mod;
        }
        return dp[n];
    }
}

