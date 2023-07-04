package day2023_03_20;


/**
 * 给你一个由二维数组 mat 表示的m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * https://leetcode.cn/problems/reshape-the-matrix/
 */
public class demo1 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int rowLength = mat.length;
        int collLength = mat[0].length;
        if ((rowLength * collLength) != (r * c)) {
            return mat;
        } else {
            int k = 0;
            int m = 0;
            int[][] ints = new int[r][c];
            for (int i = 0; i < rowLength; i++) {
                for (int j = 0; j < collLength; j++) {
                    if (m < c) {
                        ints[k][m] = mat[i][j];
                        m++;
                    }else {
                        k++;
                        m = 0;
                        ints[k][m] = mat[i][j];
                        m++;
                    }
                }
            }
            return ints;
        }
    }
}
