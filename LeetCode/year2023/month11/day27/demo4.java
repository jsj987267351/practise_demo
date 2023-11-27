package month11.day27;

import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/27 13:38
 */
public class demo4 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        int[][] dp = new int[length][length];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < length; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            res = Math.min(res, dp[length - 1][i]);
        }
        return res;
    }
}

