package LeetCode.month06.day19;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/19 10:11
 */
public class demo2 {

    public void rotate(int[][] matrix) {
        int Length = matrix.length;
//        水平翻转
        for (int row = 0; row < Length / 2; row++) {
            for (int col = 0; col < Length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[Length - row - 1][col];
                matrix[Length - row - 1][col] = temp;
            }
        }
//      左上右下主对角线翻转
        for (int row = 0; row < Length; row++) {
            for (int col = 0; col < row; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }
}

