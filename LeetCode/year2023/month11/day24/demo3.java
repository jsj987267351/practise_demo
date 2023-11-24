package month11.day24;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/24 13:01
 */
public class demo3 {
    public int maxProfit(int k, int[] prices) {
//        0: 第一次持有  1：第一次未持有 2：第二次持有 3：第二次未持有 ...
        int[] dp = new int[k * 2];
        for (int i = 0; i < k * 2; i += 2) {
            dp[i] = -prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < k * 2; j++) {
                if (j == 0) {
                    dp[j] = Math.max(dp[0], -prices[i]);
                } else if (j % 2 == 0) {
                    dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1] + prices[i]);
                }
            }
        }
        return dp[k * 2 - 1];
    }
}

