package LeetCode.month07.day05;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/5 10:24
 */
public class demo6 {
    public int pileBox(int[][] box) {
        Arrays.sort(box, (a, b) -> a[0] - b[0]);
        int len = box.length;
        int[] dp = new int[len];
        int res = box[0][2];
        for (int i = 0; i < box.length; i++) {
            dp[i] = box[i][2];
            for (int j = 0; j < i; j++) {
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + box[i][2]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

