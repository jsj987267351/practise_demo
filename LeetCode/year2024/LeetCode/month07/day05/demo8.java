package LeetCode.month07.day05;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/5 10:39
 */
public class demo8 {
    int rowLength;
    int colLength;
    int res;

    public int numIslands(char[][] grid) {
        rowLength = grid.length;
        colLength = grid[0].length;
        res = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= rowLength || col < 0 || col >= colLength || grid[row][col] != '1') return;
        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}

