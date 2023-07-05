package month05.day09;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/5/9 18:39
 */
public class demo2 {
    public void rotate1(int[][] matrix) {
        int length = matrix.length;
        int[][] m_new = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                m_new[j][length - i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = m_new[i][j];
            }
        }
    }


    public void rotate2(int[][] matrix) {
        int length = matrix.length;
//        水平翻转
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                int temp = matrix[length - i - 1][j];
                matrix[length - i - 1][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

//        主对角线翻转
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void rotate(int[][] matrix) {
        int length = matrix.length;
//        先转置
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

//        镜像
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length-j-1];
                matrix[i][length-j-1] = temp;
            }
        }
    }
}

