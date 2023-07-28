package month07.day27;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/delete-greatest-value-in-each-row/
 * @date 2023/7/27 13:00
 */
public class demo {
    public int deleteGreatestValue(int[][] grid) {
        for (int[] ints : grid) {
            Arrays.sort(ints);
        }
        int sum = 0;
        int rowLength = grid.length;
        int colLength = grid[0].length;
        for (int col = 0; col < colLength; col++) {
            int max = Integer.MIN_VALUE;
            for (int row = 0; row < rowLength; row++) {
                max = Math.max(max, grid[row][col]);
            }
            sum += max;
        }
        return sum;
    }
}

