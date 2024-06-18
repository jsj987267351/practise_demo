package LeetCode.month06.day18;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/18 13:52
 */
public class demo7 {
    int rowLength;
    int colLength;

    public int wardrobeFinishing(int m, int n, int cnt) {
        boolean[][] have = new boolean[m][n];
        rowLength = m;
        colLength = n;
        return dfs(0, 0, cnt, have);
    }

    public int dfs(int row, int col, int cnt, boolean[][] have) {
        if (row < 0 || row >= rowLength || col < 0 || col >= colLength || have[row][col] || sum(row) + sum(col) > cnt) {
            return 0;
        }
        have[row][col] = true;
        return 1 + dfs(row + 1, col, cnt, have) + dfs(row, col + 1, cnt, have);
    }

    public int sum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}

