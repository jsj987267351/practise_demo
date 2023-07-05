package month07.day04;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/4 13:20
 */
public class demo3 {
    public int maxProfit(int[] prices) {
//        dp[0]表示第一次持有股票  dp[1]表示第一次未持有股票
//        dp[2]表示第二次持有股票  dp[3]表示第二次未持有股票
        int[] dp = new int[4];
        dp[0] = -prices[0];
//        可以理解为当天买入又卖出所以为0
        dp[1] = 0;
        dp[2] = -prices[0];
        dp[3] = 0;

        for (int i = 1; i < prices.length; i++) {
//            第一次持有股票分为两种情况：
//            1.前一天也持有，所以资金不变
//            2.前一天未持有，所以即为第一次购买，即为当天股票价格的负值，因为初始资金为0
            dp[0] = Math.max(dp[0], -prices[i]);
//            第一次未持有股票也分两种情况，情况1与1相同。
//            情况2为前一天持有股票，当天未持有，即为当天第一次卖出，所以需要在前一天持有的资金基础上加上当天股票卖出的价格
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
//            前一天如果为未持有的话，那么一定是第一次未持有后的结果，所以在此基础上操作
            dp[2] = Math.max(dp[2], dp[1] - prices[i]);
//             同理
            dp[3] = Math.max(dp[3], dp[2] + prices[i]);
        }

//        肯定是第二次卖出后剩余的资金最多
        return dp[3];
    }
}

