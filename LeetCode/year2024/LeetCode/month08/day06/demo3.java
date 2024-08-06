package LeetCode.month08.day06;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/6 9:58
 */
public class demo3 {
    int rowLength;
    int colLength;
    int max;

    public int maxMoves(int[][] grid) {
        max = 0;
        rowLength = grid.length;
        colLength = grid[0].length;
        for (int row = 0; row < rowLength; row++) {
            DFS(grid, row, 0);
        }
        return max;
    }

    public void DFS(int[][] grid, int row, int col) {
        max = Math.max(max, col);
        if (col == colLength - 1) return;
        if (row > 0 && grid[row][col] < grid[row - 1][col + 1]) {
            DFS(grid, row - 1, col + 1);
        }
        if (grid[row][col] < grid[row][col + 1]) {
            DFS(grid, row, col + 1);
        }
        if (row < rowLength - 1 && grid[row][col] < grid[row + 1][col + 1]) {
            DFS(grid, row + 1, col + 1);
        }
        grid[row][col] = 0;
    }
}

