package month11.day29;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/29 17:28
 */
public class demo4 {
    public int minFallingPathSum(int[][] grid) {
        int Length = grid.length;
        for (int i = 1; i < Length; i++) {
            for (int j = 0; j < Length; j++) {
                int min = Integer.MAX_VALUE;
                for (int col = 0; col < Length; col++) {
                    if (col == j) continue;
                    min = Math.min(min, grid[i - 1][col]);
                }
                grid[i][j] += min;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < Length; i++) {
            res = Math.min(res, grid[Length - 1][i]);
        }
        return res;
    }
}

