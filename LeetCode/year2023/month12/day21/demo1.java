package month12.day21;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/21 14:18
 */
public class demo1 {
    public int pileBox(int[][] box) {
        int length = box.length;
        Arrays.sort(box, (a, b) -> a[0] - b[0]);
        int[] dp = new int[length];
        int res = box[0][2];
        dp[0] = res;
        for (int i = 1; i < length; i++) {
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

