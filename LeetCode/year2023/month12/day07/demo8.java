package month12.day07;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/7 15:09
 */
public class demo8 {
    public final int mod = 1000000007;

    public int waysToStep(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 3] + (dp[i - 2] + dp[i - 1]) % mod) % mod;
        }
        return dp[n];
    }
}

