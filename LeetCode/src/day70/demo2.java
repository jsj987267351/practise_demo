package day70;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 数独的解法需 遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/26 13:35
 */
public class demo2 {
    public void solveSudoku(char[][] board) {
        backtracking(board);
    }


    public boolean backtracking(char[][] board) {
//         遍历整张棋盘
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
//                跳过棋盘自带的数字
                if (board[i][j] != '.') {
                    continue;
                }
//                接着遍历9个数字是否符合
                for (int k = 1; k < 10; k++) {
//                    如果该数字合适,就可以填入该数字
                    if (isvalid(board, i, j, k)) {
                        board[i][j] = (char) (k + '0');
//                    递归调用,如果已经符合了，直接返回
                        if (backtracking(board)) {
                            return true;
                        }
//                    回溯
                        board[i][j] = '.';
                    }
                }
//                如果9个数字都不满足，则返回false
                return false;

            }
        }
//          遍历结束都没有返回false，则代表符合，直接返回true
        return true;

    }

    public boolean isvalid(char[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] - '0' == num) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (board[i][col] - '0' == num) {
                return false;
            }
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] - '0' == num) {
                    return false;
                }
            }
        }
        return true;
    }
}

