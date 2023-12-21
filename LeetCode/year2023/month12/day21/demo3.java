package month12.day21;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/21 15:04
 */
public class demo3 {
    int rowLength;
    int colLength;

    public int maxAreaOfIsland(int[][] grid) {
//        LCR 105. 岛屿的最大面积相同
        rowLength = grid.length;
        colLength = grid[0].length;
        int res = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == 1) {
                    int area = getArea(grid, i, j);
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }

    public int getArea(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= rowLength || col >= colLength || grid[row][col] != 1) {
            return 0;
        }
        int area = 1;
        grid[row][col] = -1;
        area += getArea(grid, row, col - 1);
        area += getArea(grid, row - 1, col);
        area += getArea(grid, row, col + 1);
        area += getArea(grid, row + 1, col);
        return area;
    }
}

