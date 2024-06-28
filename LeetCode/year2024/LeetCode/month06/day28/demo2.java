package LeetCode.month06.day28;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/28 9:33
 */
public class demo2 {
    public int maxProfit(int k, int[] prices) {
//        偶数持有，奇数未持有
        int[] dp = new int[k * 2];
        for (int i = 0; i < k * 2; i += 2) {
            dp[i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < k * 2; j += 2) {
                if (j > 0) {
                    dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
                } else {
                    dp[j] = Math.max(dp[j], -prices[i]);
                }
            }
            for (int j = 1; j < k * 2; j += 2) {
                dp[j] = Math.max(dp[j], dp[j - 1] + prices[i]);
            }
        }
        return dp[k * 2 - 1];
    }
}

