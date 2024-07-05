package LeetCode.month07.day05;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/5 9:25
 */
public class demo1 {
    public int[][] modifiedMatrix(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int[] colMax = new int[colLength];
        for (int col = 0; col < colLength; col++) {
            int curMax = Integer.MIN_VALUE;
            for (int row = 0; row < rowLength; row++) {
                curMax = Math.max(curMax, matrix[row][col]);
            }
            colMax[col] = curMax;
        }
        int[][] res = new int[rowLength][colLength];
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (matrix[row][col] == -1){
                    res[row][col] = colMax[col];
                }else {
                    res[row][col] = matrix[row][col];
                }
            }
        }
        return res;
    }
}

