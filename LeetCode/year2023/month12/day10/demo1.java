package month12.day10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/10 12:51
 */
public class demo1 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        if (n == 1) {
            return 1;
        }
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

