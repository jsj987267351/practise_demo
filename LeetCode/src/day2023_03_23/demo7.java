package day2023_03_23;

/**
 * 有效数独
 * <p>
 * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
 * https://leetcode.cn/problems/valid-sudoku/
 */
public class demo7 {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                if (row[i][num] == 1) {
                    return false;
                }
                if (col[j][num] == 1) {
                    return false;
                }
                int index = j / 3 + (i / 3) * 3;
                if (box[index][num] == 1) {
                    return false;
                }
                row[i][num] = 1;
                col[j][num] = 1;
                box[index][num] = 1;
            }
        }
        return true;
    }


}
