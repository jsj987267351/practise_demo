package month07.day05;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/5 14:12
 */
public class demo3 {
    public int maxProfit(int[] prices, int fee) {
//        动态规划
//        dp[0]持有  dp[1]未持有
        int[] dp = new int[2];
        dp[0] = -prices[0];
//        第一天未持有可能是当天买入当天卖出，然后还要出手续费，但是需要考虑利益最大化
//        因为如果当天买当天卖的话利益一定是-fee，是负数。所以可以直接不买直接利益为0更大（数组默认为0）

        for (int i = 1; i < prices.length; i++) {
//            持有状态有两种状态转移过来
//            1.前一天也是持有状态
//            2.前一天是未持有状态
            dp[0] = Math.max(dp[0],dp[1] - prices[i]);
//            未持有状态同样两种状态转移  前一天持有与未持有
//            如果前一天是持有状态的话，当天未持有就说明当天把股票卖了，所以也需要多出手续费
            dp[1] = Math.max(dp[1],dp[0] + prices[i] - fee);
        }
//        最后一定是未持有的利益最大
        return dp[1];
    }
}

