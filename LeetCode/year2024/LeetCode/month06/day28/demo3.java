package LeetCode.month06.day28;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/28 9:41
 */
public class demo3 {
    public int maxProfit(int[] prices) {
//        0持有、1保持未持有、2卖出、3冷冻期
        int[] dp = new int[4];
        dp[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            int zero = dp[0];
            int two = dp[2];
            dp[0] = Math.max(dp[0], Math.max(dp[1], dp[3]) - prices[i]);
            dp[1] = Math.max(dp[1], dp[3]);
            dp[2] = Math.max(dp[2], zero + prices[i]);
            dp[3] = two;
        }
        return Math.max(dp[1], Math.max(dp[2], dp[3]));
    }
}

