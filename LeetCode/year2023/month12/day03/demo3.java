package month12.day03;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/3 14:16
 */
public class demo3 {
    public int maxProfit(int[] prices) {
        int res = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                res = Math.max(res, prices[i] - min);
            }
        }
        return res;
    }
}

