package LeetCode.month07.day02;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/2 10:43
 */
public class demo7 {
    public String tictactoe(String[] board) {
        int length = board.length;
        char[][] chars = new char[length][length];
        for (int i = 0; i < board.length; i++) {
            chars[i] = board[i].toCharArray();
        }
        if (help(chars, 'X')) {
            return "X";
        }
        if (help(chars, 'O')) {
            return "O";
        }
        int sum = 0;
        for (char[] aChar : chars) {
            for (char c : aChar) {
                if (' ' != c) {
                    sum++;
                }
            }
        }
        return sum == length * length ? "Draw" : "Pending";
    }

    public boolean help(char[][] chars, char Win) {
        int count = 0;
//        行
        for (int row = 0; row < chars.length; row++) {
            count = 0;
            for (int col = 0; col < chars.length; col++) {
                if (chars[row][col] != Win) {
                    break;
                }
                count++;
            }
            if (count == chars.length) return true;
        }
//        列
        for (int col = 0; col < chars.length; col++) {
            count = 0;
            for (int row = 0; row < chars.length; row++) {
                if (chars[row][col] != Win) {
                    break;
                }
                count++;
            }
            if (count == chars.length) return true;
        }
        count = 0;
//        斜角
        for (int i = 0; i < chars.length; i++) {
            if (chars[i][i] != Win) {
                break;
            }
            count++;
        }
        if (count == chars.length) return true;
        count = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i][chars.length - i -1] != Win) {
                break;
            }
            count++;
        }
        return count == chars.length;
    }
}

