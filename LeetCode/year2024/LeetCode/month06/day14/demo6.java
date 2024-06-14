package LeetCode.month06.day14;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/14 14:45
 */
public class demo6 {
    public int maxProfit(int[] prices) {
        int min = prices[0], res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                res += prices[i] - min;
            }
            min = prices[i];
        }
        return res;
    }
}

