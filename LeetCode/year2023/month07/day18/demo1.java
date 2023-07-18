package month07.day18;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/18 12:31
 */
public class demo1 {
    int rowLength;
    int colLength;
    boolean[][] used;

    public boolean exist(char[][] board, String word) {
        rowLength = board.length;
        colLength = board[0].length;
        char[] words = word.toCharArray();
        used = new boolean[rowLength][colLength];
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (backtracking(board, row, col, 0, words)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtracking(char[][] board, int row, int col, int index, char[] words) {
        if (row < 0 || col < 0 || row >= rowLength || col >= colLength || index >= words.length || used[row][col]) {
            return false;
        }
        if (index == words.length - 1) {
            return board[row][col] == words[index];
        }
        if (board[row][col] != words[index]) {
            return false;
        }
        used[row][col] = true;
        boolean top = backtracking(board, row - 1, col, index + 1, words);
        boolean right = backtracking(board, row, col + 1, index + 1, words);
        boolean bottom = backtracking(board, row + 1, col, index + 1, words);
        boolean left = backtracking(board, row, col - 1, index + 1, words);

        used[row][col] = false;
        return top || right || bottom || left;
    }
}

