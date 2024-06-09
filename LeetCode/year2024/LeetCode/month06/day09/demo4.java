package LeetCode.month06.day09;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/9 17:55
 */
public class demo4 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] square = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int cur = board[i][j] - '0';
                if (row[i][cur] || col[j][cur] || square[i / 3 * 3 + j / 3][cur]) {
                    return false;
                }
                row[i][cur] = true;
                col[j][cur] = true;
                square[i / 3 * 3 + j / 3][cur] = true;
            }
        }
        return true;
    }
}

