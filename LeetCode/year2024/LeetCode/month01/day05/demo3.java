package LeetCode.month01.day05;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/5 13:05
 */
public class demo3 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[][] dp = new int[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (i == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < rowLength - 1; i++) {
            for (int j = 0; j < colLength; j++) {
                int value = grid[i][j];
                int[] cast = moveCost[value];
                for (int col = 0; col < colLength; col++) {
                    dp[i + 1][col] = Math.min(dp[i][j] + cast[col] + grid[i + 1][col], dp[i + 1][col]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int col = 0; col < colLength; col++) {
            res = Math.min(res, dp[rowLength - 1][col]);
        }
        return res;
    }
}

