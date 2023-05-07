package day36;

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
    public int maxProfit(int[] prices) {
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
}

