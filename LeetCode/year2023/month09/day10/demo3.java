package month09.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/eight-queens-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/10 13:00
 */
public class demo3 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chars = new char[n][n];
        for (char[] aChar : chars) {
            Arrays.fill(aChar, '.');
        }
        backtracking(chars, n, 0);
        return res;
    }

    public List<String> help(char[][] chars) {
        List<String> res = new ArrayList<>();
        for (char[] aChar : chars) {
            res.add(String.copyValueOf(aChar));
        }
        return res;
    }

    private void backtracking(char[][] chars, int n, int row) {
        if (row == n) {
            res.add(help(chars));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(chars, row, col, n)) {
                chars[row][col] = 'Q';
                backtracking(chars, n, row + 1);
                chars[row][col] = '.';
            }
        }
    }

    public boolean isValid(char[][] chars, int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (chars[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row -1, j = col -1; i >= 0 && j >= 0; i--, j--) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row -1 , j = col +1 ; i >=0  && j < n; i--, j++) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}

