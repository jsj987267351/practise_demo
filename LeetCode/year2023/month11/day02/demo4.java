package month11.day02;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/2 11:59
 */
public class demo4 {
    public int maxProfit(int[] prices) {
        int res = 0;
        int preMin = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < preMin) {
                preMin = prices[i];
            } else {
                res = Math.max(res, prices[i] - preMin);
            }
        }
        return res;
    }
}

