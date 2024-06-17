package LeetCode.month06.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/17 14:22
 */
public class demo7 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}

