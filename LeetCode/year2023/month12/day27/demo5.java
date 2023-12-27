package month12.day27;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/27 15:07
 */
public class demo5 {
    int rowLength;
    int colLength;
    Queue<int[]> queue;
    int goodOrange;

    public int orangesRotting(int[][] grid) {
        rowLength = grid.length;
        colLength = grid[0].length;
        queue = new LinkedList<>();
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == 1) {
                    goodOrange++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int res = 0;
        while (goodOrange > 0 && !queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] newFuLan = queue.poll();
                fuLan(grid, newFuLan[0], newFuLan[1]);
            }
        }
        if (goodOrange != 0) return -1;
        return res;
    }

    public void fuLan(int[][] grid, int row, int col) {
        if (col > 0 && grid[row][col - 1] == 1) {
            goodOrange--;
            grid[row][col - 1] = 2;
            queue.add(new int[]{row, col - 1});
        }
        if (row > 0 && grid[row - 1][col] == 1) {
            goodOrange--;
            grid[row - 1][col] = 2;
            queue.add(new int[]{row - 1, col});
        }
        if (col < colLength - 1 && grid[row][col + 1] == 1) {
            goodOrange--;
            grid[row][col + 1] = 2;
            queue.add(new int[]{row, col + 1});
        }
        if (row < rowLength - 1 && grid[row + 1][col] == 1) {
            goodOrange--;
            grid[row + 1][col] = 2;
            queue.add(new int[]{row + 1, col});
        }
    }
}

