package month08.day28;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/8/28 13:19
 */
public class demo2 {
    public void setZeroes(int[][] matrix) {
//        定义两个一维数组来表示每一行或者每一列是否有0
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        boolean[] rowIsZero = new boolean[rowLength];
        boolean[] colIsZero = new boolean[colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] == 0) {
                    rowIsZero[i] = true;
                    colIsZero[j] = true;
                }
            }
        }

//        开始置0
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (rowIsZero[i] || colIsZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

