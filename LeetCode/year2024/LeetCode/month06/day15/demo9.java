package LeetCode.month06.day15;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/15 15:15
 */
public class demo9 {
    public int maxProfit(int[] prices, int fee) {
        int[] dp = new int[2];
        dp[1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
        }
        return dp[0];
    }
}

