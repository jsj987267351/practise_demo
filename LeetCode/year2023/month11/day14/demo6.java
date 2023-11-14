package month11.day14;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/14 16:06
 */
public class demo6 {
    public void solveSudoku(char[][] board) {
        backtracking(board, 0, 0);
    }

    public boolean backtracking(char[][] board, int row, int col) {
        if (row == 8 && col == 9) {
            return true;
        }
        if (col == 9) {
            row++;
        }
        for (int i = row; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    if (isValid(board, i, j, (char) (k + '0'))) {
                        board[i][j] = (char) (k + '0');
                        if (backtracking(board,i,j+1)){
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
            if (board[i][col] == num) {
                return false;
            }
        }
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}

