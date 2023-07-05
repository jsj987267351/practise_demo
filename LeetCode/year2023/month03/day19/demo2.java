package month03.day19;

/**
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 */
public class demo2 {
    public int maxProfit1(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }else if (prices[i] - min > max)
                max = prices[i] - min;
        }
        return max;
    }


    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int length = prices.length;
        // dp[i][0]代表第i天持有股票的最大收益
        // dp[i][1]代表第i天不持有股票的最大收益
        int[][] dp = new int[length][2];
//        第1天如果持有股票的话，也就是购买股票，初始资金为0，所以为负数
        dp[0][0] = -prices[0];
//        不持有的话资金不变
        dp[0][1] = 0;
        for (int i = 1; i < length; i++) {
//            从前往后遍历
//            持有的状态分为两种，前一天持有和前一天不持有。如果前一天持有今天也持有的话，说明股票都没卖，所以资金与前一天相同
//            如果前一天不持有今天却持有的话，说明在今天购买了股票,并且一定是第一次购买，所以总资金为今天的价格负数
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
//            不持有同样分为两种，一种是前一天不持有，今天也不持有，说明一直没买，所以和前一天总资金一样
//            另一种是前一天持有，今天不持有，说明今天把股票卖了，所以总资金在前一天的基础上加上今天卖的钱
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i - 1][1]);
        }
//        最后需要返回不持有，因为股票需要卖出去
        return dp[length - 1][1];
    }

    public int maxProfit(int[] prices) {
//        二维压为1维度  dp[0]为当天持有  dp[1]为当天不持有
        int[] dp = new int[2];
        dp[0] = -prices[0];
        dp[1] = 0;
        int length = prices.length;
        for (int i = 1; i < length; i++) {
            dp[0] = Math.max(dp[0],-prices[i]);
            dp[1] = Math.max(dp[1],dp[0]+prices[i]);
        }
        return dp[1];
    }
}
