package month11.day02;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/2 11:44
 */
public class demo2 {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !help(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean help(char[][] board, int row, int col) {
        char c = board[row][col];
        for (int i = 0; i < 9; i++) {
            if (i == col) continue;
            if (board[row][i] == c) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (i == row) continue;
            if (board[i][col] == c) {
                return false;
            }
        }

        int curRow = row / 3 * 3;
        int curCol = col / 3 * 3;
        for (int i = curRow; i < curRow + 3; i++) {
            for (int j = curCol; j < curCol + 3; j++) {
                if (i == row && j == col) continue;
                if (board[i][j] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}

