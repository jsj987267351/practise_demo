package month12.day29;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/29 13:02
 */
public class demo2 {
    public int[] findSquare(int[][] matrix) {
        int length = matrix.length;
        int[][][] dp = new int[length][length][2];
        int r = -1, c = -1, size = 0;
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length; col++) {
                if (matrix[row][col] == 0) {
                    dp[row][col][0] = 1 + (col > 0 ? dp[row][col - 1][0] : 0);
                    dp[row][col][1] = 1 + (row > 0 ? dp[row - 1][col][1] : 0);
                }
                for (int side = Math.min(dp[row][col][0], dp[row][col][1]); side > size; side--) {
                    if (dp[row - side + 1][col][0] >= side && dp[row][col - side + 1][1] >= side) {
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

