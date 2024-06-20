package LeetCode.month06.day20;

import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/20 10:12
 */
public class demo5 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        for (int row = 1; row < size; row++) {
            for (int col = 0; col <= row; col++) {
                dp[row][col] = triangle.get(row).get(col);
                if (col == 0) {
                    dp[row][col] += dp[row - 1][col];
                } else if (col == row) {
                    dp[row][col] += dp[row - 1][col - 1];
                } else {
                    dp[row][col] += Math.min(dp[row - 1][col], dp[row - 1][col - 1]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int col = 0; col < size; col++) {
            res = Math.min(res, dp[size - 1][col]);
        }
        return res;
    }
}

