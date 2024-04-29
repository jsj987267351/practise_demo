package LeetCode.month04.day28;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/28 13:18
 */
public class demo1 {
    public int[] findColumnWidth(int[][] grid) {
        int len = grid[0].length;
        int[] res = new int[len];
        for (int col = 0; col < len; col++) {
            int max = 0;
            for (int row = 0; row < grid.length; row++) {
                max = Math.max(max, String.valueOf(grid[row][col]).length());
            }
            res[col] = max;
        }
        return res;
    }
}

