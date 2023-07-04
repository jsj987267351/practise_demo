package day2023_05_07;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii
 * @date 2023/5/7 16:13
 */
public class demo3 {
    public int maxProfit1(int[] prices) {
        int sum = 0;
        int low = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > low){
                sum+=prices[i] - low;
            }
            low = prices[i];
        }
        return sum;
    }


    public int maxProfit(int[] prices) {
//        dp[0]表示当天持有股票  dp[1]表示当天不持有股票
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;

        for (int i = 1; i <prices.length ; i++) {
//            当天持有股票的情况：
//            1.前一天也持有股票，说明当天没卖，即与前一天相同
//            2.前一天未持有股票，说明今天买了股票，就要在前一天未持有股票的基础上买上今天的股票，即减去当天股票的价格
            dp[0] = Math.max(dp[0],dp[1] - prices[i]);
//            同理,如果前一天有股票，而今天不持有股票，说明今天把股票卖了，就要在前一天持有股票的总资金的基础上加上今天的股票价格
            dp[1] = Math.max(dp[1],dp[0] + prices[i]);
        }

//        最后肯定是当天不持有股票的价格更高，毕竟卖出去了
        return dp[1];
    }
}

