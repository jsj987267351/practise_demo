package LeetCode.month06.day25;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/25 10:27
 */
public class demo4 {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }

    public boolean backtracking(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] != '.') continue;
                for (int num = 1; num < 10; num++) {
                    if (isValid(board,row,col,num)){
                        board[row][col] = (char) (num + '0');
                        if (backtracking(board)) return true;
                        board[row][col] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, int num) {
        for (int i = 0; i <= 8; i++) {
            if (board[row][i] - '0' == num) return false;
            if (board[i][col] - '0' == num) return false;
        }
        int startRow = row / 3 * 3, startCol = col / 3 * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] - '0' == num) return false;
            }
        }
        return true;
    }
}

