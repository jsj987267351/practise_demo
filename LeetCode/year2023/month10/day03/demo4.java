package month10.day03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/3 20:36
 */
public class demo4 {
    int rowLength;
    int colLength;
    int goodOrange;
    Queue<int[]> queue;

    public int orangesRotting(int[][] grid) {
        rowLength = grid.length;
        colLength = grid[0].length;
//        首先记录好橘子的数量，如果最后好橘子还有剩余，则代表无法腐烂完
        goodOrange = 0;
//      记录每次腐烂的新橘子的坐标
        queue = new LinkedList<>();
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == 1) {
                    goodOrange++;
                } else if (grid[i][j] == 2) {
//                    记录初始腐烂橘子的坐标
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int res = 0;
//        开始腐烂，每次腐烂都从队列中拿出该轮会扩散的腐烂的橘子
        while (goodOrange > 0 && !queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                fulan(grid, poll[0], poll[1]);
            }
        }
//        结束后还有好橘子说明无法腐烂完全，返回-1
        if (goodOrange > 0) return -1;
        return res;
    }

    //    从当前位置开始一分钟的腐烂
    public void fulan(int[][] grid, int row, int col) {
//        分别上下左右腐烂,并且将新腐烂的橘子加入带传播队列
        if (row > 0 && grid[row - 1][col] == 1) {
            grid[row - 1][col] = 2;
            goodOrange--;
            queue.offer(new int[]{row - 1, col});
        }
        if (row < rowLength - 1 && grid[row + 1][col] == 1) {
            grid[row + 1][col] = 2;
            goodOrange--;
            queue.offer(new int[]{row + 1, col});
        }
        if (col > 0 && grid[row][col - 1] == 1) {
            grid[row][col - 1] = 2;
            goodOrange--;
            queue.offer(new int[]{row, col - 1});
        }
        if (col < colLength - 1 && grid[row][col + 1] == 1) {
            grid[row][col + 1] = 2;
            goodOrange--;
            queue.offer(new int[]{row, col + 1});
        }
    }
}

