package month11.day27;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/27 13:14
 */
public class demo2 {
    public int maxProfit(int[] prices) {
//        0：持有 1：保持未持有 2：当天卖出 3：冷冻期
        int[] dp = new int[4];
        dp[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int dpTwo = dp[2], dpZero = dp[0];
            dp[0] = Math.max(dp[0], Math.max(dp[1] - prices[i], dp[3] - prices[i]));
            dp[1] = Math.max(dp[1], dp[3]);
            dp[2] = dpZero + prices[i];
            dp[3] = dpTwo;
        }
        return Math.max(dp[1], Math.max(dp[2], dp[3]));
    }
}

