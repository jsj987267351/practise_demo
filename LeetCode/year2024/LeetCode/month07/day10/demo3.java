package LeetCode.month07.day10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/10 10:08
 */
public class demo3 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
        int[][] dp = new int[rowLength][colLength];
        for (int i = 0; i < colLength; i++) {
            dp[0][i] = grid[0][i];
        }
        for (int row = 1; row < rowLength; row++) {
            int preRow = row - 1, min = Integer.MAX_VALUE;
            for (int col = 0; col < colLength; col++) {
                for (int preCol = 0; preCol < colLength; preCol++) {
                    min = Math.min(min, dp[preRow][preCol] + moveCost[grid[preRow][preCol]][col]);
                }
                dp[row][col] = min + grid[row][col];
                min = Integer.MAX_VALUE;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int col = 0; col < colLength; col++) {
            res = Math.min(res, dp[rowLength - 1][col]);
        }
        return res;
    }
}

