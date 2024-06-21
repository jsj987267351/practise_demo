package LeetCode.month06.day21;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/21 11:18
 */
public class demo10 {
    public int maximalSquare(char[][] matrix) {
        int rowLength = matrix.length, colLength = matrix[0].length, res = 0;
        int[][] dp = new int[rowLength][colLength];
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (matrix[row][col] == '1') {
                    if (row == 0 || col == 0) {
                        dp[row][col] = 1;
                    } else {
                        dp[row][col] = 1 + Math.min(Math.min(dp[row - 1][col], dp[row][col - 1]), dp[row - 1][col - 1]);
                    }
                }
                res = Math.max(res, dp[row][col]);
            }
        }
        return res * res;
    }
}

