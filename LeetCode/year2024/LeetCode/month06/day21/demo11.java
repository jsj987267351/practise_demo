package LeetCode.month06.day21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/21 11:33
 */
public class demo11 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chars = new char[n][n];
        for (char[] aChar : chars) {
            Arrays.fill(aChar, '.');
        }
        backtracking(chars, 0, n);
        return res;
    }


    public List<String> change(char[][] chars) {
        List<String> list = new ArrayList<>();
        for (char[] aChar : chars) {
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : aChar) {
                stringBuilder.append(c);
            }
            list.add(stringBuilder.toString());
        }
        return list;
    }

    public void backtracking(char[][] chars, int row, int n) {
        if (row == n) {
            res.add(change(chars));
            return;
        }
        for (int col = 0; col < chars.length; col++) {
            if (isValid(chars, row, col)) {
                chars[row][col] = 'Q';
                backtracking(chars, row + 1, n);
                chars[row][col] = '.';
            }
        }
    }

    public boolean isValid(char[][] chars, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (chars[row][col] == 'Q') return false;
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

