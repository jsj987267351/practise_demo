package month12.day05;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/5 14:29
 */
public class demo4 {
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
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (rowZero[i] || colZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

