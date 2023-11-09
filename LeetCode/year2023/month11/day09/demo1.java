package month11.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/9 12:14
 */
public class demo1 {
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] chars = new char[n][n];
        for (char[] aChar : chars) {
            Arrays.fill(aChar, '.');
        }
        backtracking(chars, n, 0);
        return res;
    }

    public void backtracking(char[][] chars, int n, int row) {
        if (row == n) {
            res.add(help(chars));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(chars, n, row, col)) {
                chars[row][col] = 'Q';
                backtracking(chars, n, row + 1);
                chars[row][col] = '.';
            }
        }
    }

    public boolean isValid(char[][] chars, int n, int row, int col) {
        for (int i = 0; i < row; i++) {
            if ((chars[i][col]) == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public List<String> help(char[][] chars) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chars.length; j++) {
                sb.append(chars[i][j]);
            }
            res.add(sb.toString());
        }
        return res;
    }
}

