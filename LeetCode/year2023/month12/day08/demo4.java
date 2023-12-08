package month12.day08;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/8 14:13
 */
public class demo4 {
    private double single = 1.0 / 6.0;

    public double[] statisticsProbability(int num) {
        double[] dp = new double[6];
        Arrays.fill(dp, single);
        for (int i = 2; i <= num; i++) {
            double[] temp = new double[i * 5 + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += dp[j] * (single);
                }
            }
            dp = temp;
        }
        return dp;
    }
}

