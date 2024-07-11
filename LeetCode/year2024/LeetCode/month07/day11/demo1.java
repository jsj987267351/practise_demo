package LeetCode.month07.day11;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/11 9:38
 */
public class demo1 {
    public int[] findSquare(int[][] matrix) {
        int r = -1, c = -1, size = 0;
        int len = matrix.length;
        int[][][] dp = new int[len][len][2];
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                if (matrix[row][col] == 0) {
                    dp[row][col][0] = 1 + (col > 0 ? dp[row][col - 1][0] : 0);
                    dp[row][col][1] = 1 + (row > 0 ? dp[row - 1][col][1] : 0);
                }
                for (int side = Math.min(dp[row][col][0], dp[row][col][1]); side > size; side--) {
                    if (dp[row][col - side + 1][1] >= side && dp[row - side + 1][col][0] >= side) {
                        size = side;
                        r = row - side + 1;
                        c = col - side + 1;
                        break;
                    }
                }
            }
        }
        if (r == -1) return new int[]{};
        return new int[]{r, c, size};
    }
}

