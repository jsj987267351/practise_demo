package month07.day05;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/5 13:20
 */
public class demo2 {
    public int maxProfit(int[] prices) {
//        动态规划  dp[0]持有  dp[1]保持未持有  dp[2]当天卖出  dp[3]冷冻期
//        将未持有分开来是因为冷冻期只能由前一天是卖出的状态得来
        int[] dp = new int[4];
//        初始化第一天持有状态是第一次购买股票，开始底薪为0，所以为-prices[0] ，其余初始化为0（默认就是0）是因为
//        当天卖出的话肯定是0，相当于当天买当天卖没有利润。另外两个是废话状态，可以带入得出
        dp[0] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
//            先临时存储dp[0]和dp[2]，因为后续这两个会改变，而dp[2]和dp[3]的改变还需要这两个变量不改变时候的状态
            int dpZero = dp[0];
            int dpTwo = dp[2];
//            持有状态可由三个状态变化而来
//            1.前一天也是持有状态
//            2.前一天是保持未持有状态
//            3.前一天是冷冻期
            dp[0] = Math.max(dp[0], Math.max(dp[1] - prices[i], dp[3] - prices[i]));
//            保持未持有状态可由两种状态变化而来
//            1.前一天也是保持未持有状态
//            2.前一天是冷冻状态
            dp[1] = Math.max(dp[1], dp[3]);
//            当天卖出状态只能由一种状态转换，就是前一天是持有状态
            dp[2] = dpZero + prices[i];
//            冷冻期状态只能由一种状态转换，就是前一天是卖出状态
            dp[3] = dpTwo;
        }

//        最后利益最大的状态除了持有股票都有可能
        return Math.max(dp[1], Math.max(dp[2], dp[3]));
    }
}


