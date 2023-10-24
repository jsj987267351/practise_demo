package month10.day24;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/rotate-image/description/?envType=list&envId=hliQiQFH
 * @date 2023/10/24 12:47
 */
public class demo2 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j - 1];
                matrix[i][len - j - 1] = temp;
            }
        }
    }
}

