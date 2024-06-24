package LeetCode.month06.day24;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/24 10:20
 */
public class demo4 {
    int rowLength;
    int colLength;
    int end;
    boolean[][] used;

    public boolean exist(char[][] board, String word) {
        char[] charArray = word.toCharArray();
        rowLength = board.length;
        colLength = board[0].length;
        end = word.length();
        used = new boolean[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (backtracking(board, charArray, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtracking(char[][] board, char[] charArray, int index, int row, int col) {
        if (index == end) return true;
        if (row < 0 || row >= rowLength || col < 0 || col >= colLength || board[row][col] != charArray[index] || used[row][col]) {
            return false;
        }
        used[row][col] = true;
        boolean top = backtracking(board, charArray, index + 1, row - 1, col);
        boolean bottom = backtracking(board, charArray, index + 1, row + 1, col);
        boolean left = backtracking(board, charArray, index + 1, row, col - 1);
        boolean right = backtracking(board, charArray, index + 1, row, col + 1);
        used[row][col] = false;
        return top || bottom || left || right;
    }
}

