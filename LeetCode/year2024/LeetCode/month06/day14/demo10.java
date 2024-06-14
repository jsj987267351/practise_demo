package LeetCode.month06.day14;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/14 15:14
 */
public class demo10 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowLength = obstacleGrid.length;
        int colLength = obstacleGrid[0].length;
        int[][] dp = new int[rowLength][colLength];
        for (int i = 0; i < colLength; i++) {
            if (obstacleGrid[0][i] == 1) break;
            dp[0][i] = 1;
        }
        for (int i = 0; i < rowLength; i++) {
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[rowLength - 1][colLength - 1];
    }
}

