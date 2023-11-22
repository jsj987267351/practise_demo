package month11.day22;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/22 13:55
 */
public class demo4 {
    boolean[][] used;

    public int wardrobeFinishing(int m, int n, int cnt) {
        used = new boolean[m][n];
        return backtracking(m, n, cnt, 0, 0);
    }

    public int backtracking(int m, int n, int cnt, int row, int col) {
        if (row < 0 || col < 0 || row >= m || col >= n || used[row][col] || getDigit(row) + getDigit(col) > cnt) {
            return 0;
        }
        used[row][col] = true;
        return 1 + backtracking(m, n, cnt, row, col + 1) + backtracking(m, n, cnt, row + 1, col);
    }

    public int getDigit(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}

