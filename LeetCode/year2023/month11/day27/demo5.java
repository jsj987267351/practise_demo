package month11.day27;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/27 13:46
 */
public class demo5 {
    public void gameOfLife(int[][] board) {
        int rowLength = board.length;
        int colLength = board[0].length;
        int[][] temp = new int[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
//                判断周围8个方位
//                记录周围活细胞的数目
                int count = 0;
//                左上
                if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 1) count++;
//                正上
                if (i - 1 >= 0 && board[i - 1][j] == 1) count++;
//                右上
                if (i - 1 >= 0 && j + 1 < colLength && board[i - 1][j + 1] == 1) count++;
//                右边
                if (j + 1 < colLength && board[i][j + 1] == 1) count++;
//                右下
                if (i + 1 < rowLength && j + 1 < colLength && board[i + 1][j + 1] == 1) count++;
//                正下
                if (i + 1 < rowLength && board[i + 1][j] == 1) count++;
//                左下
                if (i + 1 < rowLength && j - 1 >= 0 && board[i + 1][j - 1] == 1) count++;
//                左边
                if (j - 1 >= 0 && board[i][j - 1] == 1) count++;
//                判断细胞状态与周围活细胞数目的关系
                if (board[i][j] == 0 && count == 3 || board[i][j] == 1 && (count == 2 || count == 3)) {
                    temp[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                board[i][j] = temp[i][j];
            }
        }
    }
}

