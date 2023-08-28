package month08.day28;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * https://leetcode.cn/problems/rotate-matrix-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/8/28 13:04
 */
public class demo1 {
    public void rotate1(int[][] matrix) {
        int length = matrix.length;
        int[][] tmp = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                tmp[j][length - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = tmp[i][j];
            }
        }
    }

    public void rotate(int[][] matrix) {
//        先沿正对角线翻转然后垂直镜像翻转  或者先沿副对角线翻转然后水平镜像翻转
//        这里采用第一种
        int length = matrix.length;
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < row; col++) {
//                对角线不反转所以不用<=
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = tmp;
            }
        }
//        垂直镜像
        for (int col = 0; col < length / 2; col++) {
            for (int row = 0; row < length; row++) {
                int tmp = matrix[row][col];
                matrix[row][col] = matrix[row][length - col - 1];
                matrix[row][length - col - 1] = tmp;
            }
        }
    }
}

