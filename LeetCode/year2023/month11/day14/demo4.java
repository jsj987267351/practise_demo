package month11.day14;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/14 15:25
 */
public class demo4 {
    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int[] dp = new int[2];
//        dp[0]未持有，dp[1]持有
        dp[1] = -prices[0];
        for (int i = 1; i < length; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
        }
        return dp[0];
    }
}

