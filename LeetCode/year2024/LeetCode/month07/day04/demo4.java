package LeetCode.month07.day04;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/4 10:12
 */
public class demo4 {
    int rowLength;
    int colLength;

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        rowLength = grid.length;
        colLength = grid[0].length;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (grid[row][col] == 1) {
                    int curArea = area(grid, row, col);
                    res = Math.max(res, curArea);
                }
            }
        }
        return res;
    }

    public int area(int[][] grid, int row, int col) {
        if (row < 0 || row >= rowLength || col < 0 || col >= colLength || grid[row][col] != 1) {
            return 0;
        }
        int curArea = 1;
        grid[row][col] = 0;
        return curArea + area(grid, row - 1, col) + area(grid, row, col - 1) + area(grid, row, col + 1) + area(grid, row + 1, col);
    }
}

