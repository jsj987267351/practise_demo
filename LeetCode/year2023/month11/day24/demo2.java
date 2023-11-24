package month11.day24;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/24 12:55
 */
public class demo2 {
    public int maxProfit(int[] prices) {
//        0: 第一次持有  1：第一次未持有 2：第二次持有 3：第二次未持有
        int[] dp = new int[4];
        dp[0] = -prices[0];
        dp[1] = 0;
        dp[2] = -prices[0];
        dp[3] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], -prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
            dp[2] = Math.max(dp[2], dp[1] - prices[i]);
            dp[3] = Math.max(dp[3], dp[2] + prices[i]);
        }
        return dp[3];
    }
}

