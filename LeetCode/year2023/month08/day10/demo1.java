package month08.day10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/8/10 14:50
 */
public class demo1 {
    public int minFallingPathSum(int[][] grid) {
//        注意题目的解题要求不一定是相邻下来，而是只要不是与当前数字同一列即可，所以每次选取上一列中不与当前数字同一列中的最小值相加即可
        int Length = grid.length;
        for (int row = 1; row < Length; row++) {
            for (int col = 0; col < Length; col++) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < Length; i++) {
                    if (i == col) continue;
                    min = Math.min(min, grid[row - 1][i]);
                }
                grid[row][col] += min;
            }
        }
        int row = Length - 1;
        int res = grid[row][0];
        for (int col = 1; col < Length; col++) {
            res = Math.min(res, grid[row][col]);
        }
        return res;
    }
}

