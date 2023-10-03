package month10.day03;

import java.security.PublicKey;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/3 20:25
 */
public class demo3 {
    int rowLength;
    int colLength;

    public int numIslands(char[][] grid) {
        rowLength = grid.length;
        colLength = grid[0].length;
        int res = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
//                当前为陆地才需要进行查找
                if (grid[i][j] == '1'){
                    help(grid, i, j);
//               执行到这一步代表上一步执行结束，找到了一个岛屿
                    res++;
                }
            }
        }
        return res;
    }

    public void help(char[][] grid, int row, int col) {
//        代表找到水了
        if (row < 0 || col < 0 || row >= rowLength || col >= colLength || grid[row][col] == '0') {
            return;
        }
//        标记该地找过了,置为水即可
        grid[row][col] = '0';
//        找剩余四个方向，直到四个方向都找到水或者到边界才可返回
        help(grid, row - 1, col);
        help(grid, row, col + 1);
        help(grid, row + 1, col);
        help(grid, row, col - 1);
    }
}

