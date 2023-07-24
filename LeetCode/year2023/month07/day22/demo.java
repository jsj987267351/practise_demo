package month07.day22;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/?envType=study-plan-v2&envId=coding-interviews
 * @date 2023/7/22 13:30
 */
public class demo {
    public int maxProfit1(int[] prices) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        if (prices.length ==0){
            return 0;
        }
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[0] = Math.max(dp[0],  -prices[i]);
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
        }
        return dp[1];
    }
}

