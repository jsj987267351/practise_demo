package month07.day05;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格，和一个整型 k 。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/5 13:00
 */
public class demo1 {
    public int maxProfit(int k, int[] prices) {
//        特判
        int length = prices.length;
        if (k == 0 || length == 0) {
            return 0;
        }
//        动态规划
//        dp[0]代表第一次持有 dp[1]代表第一次未持有，以此往后类推
        int[] dp = new int[2 * k];
//        初始化，刚开始所有第一次持有的总价值都为-prices[0],都当作第一天买了又卖，所以皆为第一次购买
        for (int i = 0; i < 2 * k; i += 2) {
            dp[i] = -prices[0];
        }

        for (int i = 1; i < length; i++) {
//            第一次持有，有可能前一天未持有，也有可能前一天持有，取最大值
            dp[0] = Math.max(dp[0], -prices[i]);
//            第一次未持同理，有两种情况
            dp[1] = Math.max(dp[1], dp[0] + prices[i]);
//            后续每一天同理
            for (int j = 2; j < 2 * k; j += 2) {
//                持有
                dp[j] = Math.max(dp[j], dp[j - 1] - prices[i]);
//                未持有
                dp[j + 1] = Math.max(dp[j + 1], dp[j] + prices[i]);
            }
        }
//        最后返回最后一次未持有情况即可
        return dp[2 * k - 1];
    }
}

