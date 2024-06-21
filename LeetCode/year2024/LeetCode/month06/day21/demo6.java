package LeetCode.month06.day21;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/21 10:26
 */
public class demo6 {
    int res = 0;

    public int totalNQueens(int n) {
        char[][] chars = new char[n][n];
        for (char[] aChar : chars) {
            Arrays.fill(aChar, '.');
        }
        backtracking(chars, 0, n);
        return res;
    }

    public void backtracking(char[][] chars, int row, int n) {
        if (row == n) {
            res++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(chars, row, col)) {
                chars[row][col] = 'Q';
                backtracking(chars, row + 1, n);
                chars[row][col] = '.';
            }
        }
    }

    public boolean isValid(char[][] chars, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (chars[row][i] == 'Q') return false;
        }
        for (int i = 0; i < row; i++) {
            if (chars[i][col] == 'Q') return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chars[i][j] == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < chars.length; i--, j++) {
            if (chars[i][j] == 'Q') return false;
        }
        return true;
    }
}

