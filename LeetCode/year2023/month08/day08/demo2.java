package month08.day08;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/8/8 14:58
 */
public class demo2 {
    int res = 0;
//      与N皇后1同理，只不过不用返回所有结果，只需要返回结果的数量即可，所以直接定义变量计数即可
    public int totalNQueens(int n) {
        char[][] chars = new char[n][n];
        for (char[] aChar : chars) {
            Arrays.fill(aChar, '.');
        }
        backtracking(n, chars, 0);
        return res;
    }

    public void backtracking(int n, char[][] chars, int row) {
        if (row == n) {
            res++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isvalid(n, row, col, chars)) {
                chars[row][col] = 'Q';
                backtracking(n, chars, row + 1);
                chars[row][col] = '.';
            }
        }
    }

    public boolean isvalid(int n, int row, int col, char[][] chars) {
        for (int i = 0; i < row; i++) {
            if (chars[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}

