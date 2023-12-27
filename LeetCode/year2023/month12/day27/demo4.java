package month12.day27;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/27 15:02
 */
public class demo4 {
    int rowLength;
    int colLength;

    public int numIslands(char[][] grid) {
        rowLength = grid.length;
        colLength = grid[0].length;
        int res = 0;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (grid[row][col] == '1') {
                    Area(grid, row, col);
                    res++;
                }
            }
        }
        return res;
    }

    public void Area(char[][] grid, int row, int col) {
        if (row < 0 || row >= rowLength || col < 0 || col >= colLength || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = 'X';
        Area(grid, row, col - 1);
        Area(grid, row - 1, col);
        Area(grid, row, col + 1);
        Area(grid, row + 1, col);
    }
}

