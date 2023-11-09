package month11.day09;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/9 12:33
 */
public class demo3 {
    public boolean exist(char[][] board, String word) {
        int rowLength = board.length;
        int colLength = board[0].length;
        boolean[][] used = new boolean[rowLength][colLength];
        char[] words = word.toCharArray();
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (help(board, used, words, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean help(char[][] board, boolean[][] used, char[] words, int index, int row, int col) {
        if (index == words.length) {
            return true;
        }
        if (row >= board.length || col >= board[0].length || row < 0 || col < 0 || used[row][col] || words[index] != board[row][col]) {
            return false;
        }
        used[row][col] = true;
        boolean left = help(board, used, words, index + 1, row, col - 1);
        boolean up = help(board, used, words, index + 1, row - 1, col);
        boolean right = help(board, used, words, index + 1, row, col + 1);
        boolean down = help(board, used, words, index + 1, row + 1, col);
        used[row][col] = false;
        return left || up || right || down;
    }
}

