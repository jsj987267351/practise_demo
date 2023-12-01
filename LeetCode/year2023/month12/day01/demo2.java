package month12.day01;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/1 12:42
 */
public class demo2 {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[][] dp = new int[rowLength][colLength];
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (matrix[row][col] == '1') {
                    if (row == 0 || col == 0) {
                        dp[row][col] = 1;
                    } else {
                        dp[row][col] = Math.min(dp[row - 1][col - 1], Math.min(dp[row - 1][col], dp[row][col - 1])) + 1;
                    }
                }
                maxSide = Math.max(maxSide, dp[row][col]);
            }
        }
        return maxSide * maxSide;
    }
}

