package LeetCode.month07.day04;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/4 9:49
 */
public class demo3 {
    public double[] statisticsProbability(int num) {
        double[] res = new double[6];
        Arrays.fill(res, 1.0 / 6.0);
        for (int i = 2; i <= num; i++) {
            double[] dp = new double[i * 5 + 1];
            for (int j = 0; j < res.length; j++) {
                for (int k = 0; k < 6; k++) {
                    dp[j + k] += res[j] * (1.0 / 6.0);
                }
            }
            res = dp;
        }
        return res;
    }
}

