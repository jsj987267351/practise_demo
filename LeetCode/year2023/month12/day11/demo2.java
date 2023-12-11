package month12.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/11 12:51
 */
public class demo2 {
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> res = new ArrayList<>();
        int rowLength = obstacleGrid.length;
        int colLength = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[rowLength-1][colLength-1] == 1){
            return res;
        }
        boolean[][] CanGoWays = new boolean[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            CanGoWays[i][0] = true;
        }
        for (int i = 0; i < colLength; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            CanGoWays[0][i] = true;
        }
        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                if (obstacleGrid[i][j] == 0) {
                    CanGoWays[i][j] = CanGoWays[i - 1][j] || CanGoWays[i][j - 1];
                }
            }
        }
        if (!CanGoWays[rowLength - 1][colLength - 1]) {
            return res;
        }
        int row = rowLength - 1, col = colLength - 1;
        while (row >= 0 && col >= 0) {
            res.add(Arrays.asList(row, col));
            if (row > 0 && CanGoWays[row - 1][col]) {
                row--;
            } else  {
                col--;
            }
        }
        Collections.reverse(res);
        return res;
    }
}

