package day2023_06_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/12 13:57
 */
public class demo3 {

    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
//        定义棋盘，初始赋值都为'.'，因为都还没放棋子
        char[][] chars = new char[n][n];
        for (char[] aChar : chars) {
            Arrays.fill(aChar, '.');
        }
        backtracking(n, chars, 0);
        return result;

    }

    //    辅助函数，将char[][] 数组转变成List<String>，按行转变
    public List help(char[][] chars) {
        List<String> list = new ArrayList<>();
        for (char[] aChar : chars) {
//            遍历每一行，然后转变成字符串加入集合
            list.add(String.copyValueOf(aChar));
        }
        return list;
    }

    //    row 代表当前行， n代表边界
    public void backtracking(int n, char[][] chars, int row) {
        if (row == n) {
//            说明遍历完最后一行了，可以收集结果了，判断条件在递归里写
            result.add(help(chars));
            return;
        }
//        遍历，索引col代表列,row代表当前行，每一行开始遍历
        for (int col = 0; col < n; col++) {
            if (isValid(chars, row, col, n)) {
//                说明当前位置可以放，所以放入棋子
                chars[row][col] = 'Q';
//                递归，开始下一行进行判断
                backtracking(n, chars, row + 1);
//                回溯
                chars[row][col] = '.';
            }
        }
    }

    //    判断当前期盼是否符合要求
    public boolean isValid(char[][] chars, int row, int col, int n) {
//        判断列,剪枝操作，只需要判断当前列之前的所有列即可，行不用判断，因为回溯用的行。
        for (int i = 0; i < row; i++) {
            if (chars[i][col] == 'Q') {
                return false;
            }
        }

//        判断45度,同理，只需要判断当前行之前的所有行的右上角45度即可
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }

//        判断135度，同理，只需要判断当前行之前的所有行的左上角135度即可
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}

