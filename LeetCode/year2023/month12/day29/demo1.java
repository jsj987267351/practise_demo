package month12.day29;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/29 12:26
 */
public class demo1 {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int res = money - prices[0] - prices[1];
        return res < 0 ? money : res;
    }
}

