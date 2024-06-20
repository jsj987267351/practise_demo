package LeetCode.month06.day20;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/20 10:28
 */
public class demo6 {
    int rowLength;
    int colLength;

    public void gameOfLife(int[][] board) {
        rowLength = board.length;
        colLength = board[0].length;
        int[][] dp = new int[rowLength][colLength];
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                dp[row][col] = count(board, row, col);
            }
        }
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                int count = dp[row][col];
                if (board[row][col] == 0 && count == 3) {
                    board[row][col] = 1;
                } else if (board[row][col] == 1 && (count < 2 || count > 3)) {
                    board[row][col] = 0;
                }
            }
        }
    }

    public int count(int[][] board, int row, int col) {
        int count = 0;
        for (int i = Math.max(row - 1, 0); i < Math.min(rowLength, row + 2); i++) {
            for (int j = Math.max(col - 1, 0); j < Math.min(colLength, col + 2); j++) {
                if (i == row && j == col) continue;
                count += board[i][j];
            }
        }
        return count;
    }
}

