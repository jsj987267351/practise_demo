package month09.day08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/8 14:35
 */
public class demo2 {
    public List<List<Integer>> pathWithObstacles1(int[][] obstacleGrid) {
        List<List<Integer>> list = new ArrayList<>();
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
//        用来记录到达每个点的方法总数
        int[][] temp = new int[r][c];
        for (int i = 0; i < c; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            temp[0][i] = 1;
        }
        for (int i = 0; i < r; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            temp[i][0] = 1;
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (obstacleGrid[i][j] == 1) {
                    temp[i][j] = 0;
                } else {
                    temp[i][j] = temp[i - 1][j] + temp[i][j - 1];
                }
            }
        }
//        首先判断是否能够到达终点
        if (temp[r - 1][c - 1] == 0) {
            return list;
        }

//        从终点倒推，因为能到达终点，所以一定最少有一条路能够走通，从尾到头只能走左和上，所以走左的话列数-1，走上行数-1
        int row = r - 1, col = c - 1;
        while (row >= 0 && col >= 0) {
//            每次都将路过的路径加入结果
            list.add(Arrays.asList(row, col));
            if (row > 0 && temp[row - 1][col] != 0) {
                row--;
            } else {
                col--;
            }
        }
        Collections.reverse(list);
        return list;
    }


    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> list = new ArrayList<>();
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
//        特判
        if (obstacleGrid[0][0] == 1 || obstacleGrid[r - 1][c - 1] == 1) return list;
//        用来记录每个点是否可到达
        boolean[][] temp = new boolean[r][c];
        for (int i = 0; i < c; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            temp[0][i] = true;
        }
        for (int i = 0; i < r; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            temp[i][0] = true;
        }
        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (obstacleGrid[i][j] == 0) {
                    temp[i][j] = temp[i - 1][j] || temp[i][j - 1];
                }
            }
        }
//        首先判断是否能够到达终点
        if (!temp[r - 1][c - 1]) {
            return list;
        }

//        从终点倒推，因为能到达终点，所以一定最少有一条路能够走通，从尾到头只能走左和上，所以走左的话列数-1，走上行数-1
        int row = r - 1, col = c - 1;
        while (row >= 0 && col >= 0) {
//            每次都将路过的路径加入结果
            list.add(Arrays.asList(row, col));
            if (row > 0 && temp[row - 1][col]) {
                row--;
            } else {
                col--;
            }
        }
        Collections.reverse(list);
        return list;
    }
}

