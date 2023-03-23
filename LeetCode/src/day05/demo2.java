package day05;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 */
public class demo2 {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int call = matrix[0].length;
        int[][] result = new int[row][call];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < call; j++) {
                if (matrix[i][j] == 0) {
                    result[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < call; j++) {
                if (result[i][j] == 1) {
                    for (int k = 0; k < call; k++) {
                        if (matrix[i][k] == 0) {
                            continue;
                        }
                        matrix[i][k] = 0;
                    }
                    for (int k = 0; k < row; k++) {
                        if (matrix[k][j] == 0) {
                            continue;
                        }
                        matrix[k][j] = 0;
                    }
                }
            }
        }

    }
}
