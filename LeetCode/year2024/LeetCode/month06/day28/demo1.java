package LeetCode.month06.day28;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/28 9:22
 */
public class demo1 {
    public int maxProfit(int[] prices) {
        int[] dp = new int[4];
//        0第一次持有，1第一次未持有，2第二次持有，3第二次未持有
        dp[0] = -prices[0];
        dp[2] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
            dp[2] = Math.max(dp[2], dp[1] - prices[i]);
            dp[3] = Math.max(dp[3], dp[2] + prices[i]);
        }
        return dp[3];
    }
}

