package LeetCode.month07.day08;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/8 17:28
 */
public class demo11 {
    int rowLength;
    int colLength;
    Queue<int[]> queue;
    int goodCount;

    public int orangesRotting(int[][] grid) {
        rowLength = grid.length;
        colLength = grid[0].length;
        queue = new LinkedList<>();
        goodCount = 0;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == 1) {
                    goodCount++;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int res = 0;
        while (goodCount > 0 && !queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] need = queue.poll();
                fuLan(grid, need[0], need[1]);
            }
        }
        return goodCount == 0 ? res : -1;
    }

    public void fuLan(int[][] grid, int row, int col) {
        if (col > 0 && grid[row][col - 1] == 1) {
            goodCount--;
            grid[row][col - 1] = 2;
            queue.add(new int[]{row, col - 1});
        }
        if (row > 0 && grid[row - 1][col] == 1) {
            goodCount--;
            grid[row - 1][col] = 2;
            queue.add(new int[]{row - 1, col});
        }
        if (col < colLength - 1 && grid[row][col + 1] == 1) {
            goodCount--;
            grid[row][col + 1] = 2;
            queue.add(new int[]{row, col + 1});
        }
        if (row < rowLength - 1 && grid[row + 1][col] == 1) {
            goodCount--;
            grid[row + 1][col] = 2;
            queue.add(new int[]{row + 1, col});
        }
    }
}

