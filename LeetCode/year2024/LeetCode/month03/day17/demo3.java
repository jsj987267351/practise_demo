package LeetCode.month03.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/17 16:30
 */
public class demo3 {
    int max;
    int rowLength;
    int colLength;

    public int maxMoves(int[][] grid) {
        rowLength = grid.length;
        colLength = grid[0].length;
        max = 0;
        for (int row = 0; row < rowLength; row++) {
            DFS(grid, row, 0);
        }
        return max;
    }


    public void DFS(int[][] grid, int row, int col) {
        max = Math.max(max, col);
        if (max == colLength - 1) return;
        if (row > 0 && col < colLength - 1 && grid[row][col] < grid[row - 1][col + 1]) {
            DFS(grid, row - 1, col + 1);
        }
        if (col < colLength - 1 && grid[row][col] < grid[row][col + 1]) {
            DFS(grid, row, col + 1);
        }
        if (row < rowLength - 1 && col < colLength - 1 && grid[row][col] < grid[row + 1][col + 1]) {
            DFS(grid, row + 1, col + 1);
        }
//        防止重复访问
        grid[row][col] = 0;
    }
}

