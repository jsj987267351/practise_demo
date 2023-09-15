package month09.day15;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/15 12:28
 */
public class demo3 {
    public String tictactoe(String[] board) {
//        将字符串数组转变为棋盘
        int length = board.length;
        char[][] chars = new char[length][length];
        for (int i = 0; i < length; i++) {
            chars[i] = board[i].toCharArray();
        }
//        记录棋盘中空格的数量，如果空格的数量大于0且未分出胜负的话就是游戏未结束，如果空格数量等于0且未分出胜负的话就是平局
        int SpaceNum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (chars[i][j] == ' ') {
                    SpaceNum++;
                }
            }
        }
//        判断空格数量
        if (SpaceNum > 0) {
            if (help(chars, 'X')) return "X";
            if (help(chars, 'O')) return "O";
//            未分出胜负也有空格，则游戏未结束
            return "Pending";
        }
        if (help(chars, 'X')) return "X";
        if (help(chars, 'O')) return "O";
//            未分出胜负也没有空格，则游戏平局
        return "Draw";
    }

    //    判断在棋盘chars中 字符x是否赢了.字符x能赢的情况只有行列和对角线，挨个判断即可
    private boolean help(char[][] chars, char x) {
        int length = chars.length;
//        首先判断是否有一行练成
        for (int row = 0; row < length; row++) {
            int col;
            for (col = 0; col < length; col++) {
                if (chars[row][col] != x) break;
            }
//            判断完当前行之后查看列是否遍历到了最后一列，如果遍历到了最后一列说明当前行有连子，返回true
            if (col == length) return true;
        }

//        同理判断列
        for (int col = 0; col < length; col++) {
            int row;
            for (row = 0; row < length; row++) {
                if (chars[row][col] != x) break;
            }
            if (row == length) return true;
        }
//        判断主对角线
        int t;
        for (t = 0; t < length; t++) {
            if (chars[t][t] != x) break;
        }
        if (t == length) return true;

//       判断副对角线
        for (t = 0; t < length; t++) {
            if (chars[t][length - t - 1] != x) break;
        }
        return t == length;
    }

}

