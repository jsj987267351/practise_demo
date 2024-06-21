package LeetCode.month06.day21;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/21 11:11
 */
public class demo9 {
    public int minFallingPathSum(int[][] grid) {
        int len = grid.length;
        int[][] dp = new int[len][len];
        for (int col = 0; col < len; col++) {
            dp[0][col] = grid[0][col];
        }
        for (int row = 1; row < len; row++) {
            int preRpw = row - 1;
            for (int col = 0; col < len; col++) {
                int min = Integer.MAX_VALUE;
                for (int preCol = 0; preCol < len; preCol++) {
                    if (col == preCol) continue;
                    min = Math.min(min, dp[preRpw][preCol]);
                }
                dp[row][col] = grid[row][col] + min;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int col = 0; col < len; col++) {
            res = Math.min(res, dp[len - 1][col]);
        }
        return res;
    }
}

