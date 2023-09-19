package month09.day19;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/ZL6zAn/description/
 * @date 2023/9/19 13:13
 */
public class demo4 {
    int rowLength;
    int colLength;

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        rowLength = grid.length;
        colLength = grid[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
//                只有当前为岛屿才可遍历
                if (grid[i][j] == 1) {
                    res = Math.max(res, getArea(grid, i, j));
                }
            }
        }
        return res;
    }

//    返回以grit[row][col]为起点的下标的周围最大岛屿
    public int getArea(int[][] grid, int row, int col) {
//        特判
        if (row < 0 || col < 0 || row >= rowLength || col >= colLength || grid[row][col] != 1) return 0;
//         将当前岛屿标记为遍历过，防止重复遍历
        grid[row][col] = -1;
//        当前岛屿面积
        int curSum = 1;

//        加上四个方向的面积
        curSum += getArea(grid, row - 1, col);
        curSum += getArea(grid, row, col + 1);
        curSum += getArea(grid, row + 1, col);
        curSum += getArea(grid, row, col - 1);
        return curSum;
    }
}

