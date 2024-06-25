package LeetCode.month06.day25;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/25 11:04
 */
public class demo6 {
    public void setZeroes(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        boolean[] rowZero = new boolean[rowLength];
        boolean[] colZero = new boolean[colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] == 0) {
                    rowZero[i] = true;
                    colZero[j] = true;
                }
            }
        }
        for (int row = 0; row < rowLength; row++) {
            if (rowZero[row]) {
                for (int i = 0; i < colLength; i++) {
                    matrix[row][i] = 0;
                }
            }
        }
        for (int col = 0; col < colLength; col++) {
            if (colZero[col]) {
                for (int i = 0; i < rowLength; i++) {
                    matrix[i][col] = 0;
                }
            }
        }
    }
}

