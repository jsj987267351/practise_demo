package month11.day10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/10 14:37
 */
public class demo6 {
    public int maxProfit(int[] prices) {
        int[] dp = new int[2];
//        未持有
        dp[0] = 0;
//        持有
        dp[1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
        }
        return dp[0];
    }

    public int maxProfit1(int[] prices) {
        int res = 0, pre = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > pre) {
                res += prices[i] - pre;
            }
            pre = prices[i];
        }
        return res;
    }
}

