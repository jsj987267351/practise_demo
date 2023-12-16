package month12.day16;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/16 17:03
 */
public class demo1 {
    public String tictactoe(String[] board) {
        int length = board.length;
        char[][] chars = new char[length][length];
        for (int i = 0; i < length; i++) {
            chars[i] = board[i].toCharArray();
        }
        if (help(chars, 'X')) {
            return "X";
        }
        if (help(chars, 'O')) {
            return "O";
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (chars[i][j] == ' ') {
                    count++;
                }
            }
        }
        if (count == 0) {
            return "Draw";
        } else {
            return "Pending";
        }
    }

    public boolean help(char[][] chars, char target) {
        int length = chars.length;
        int count = 0;
        for (int row = 0; row < length; row++) {
            count = 0;
            for (int col = 0; col < length; col++) {
                if (chars[row][col] != target) {
                    break;
                } else {
                    count++;
                }
            }
            if (count == length) {
                return true;
            }
        }

        for (int col = 0; col < length; col++) {
            count = 0;
            for (int row = 0; row < length; row++) {
                if (chars[row][col] != target) {
                    break;
                } else {
                    count++;
                }
            }
            if (count == length) return true;
        }
        count = 0;
        for (int i = 0; i < length; i++) {
            if (chars[i][i] != target) break;
            count++;
        }
        if (count == length) return true;
        count = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (chars[i][length - i - 1] != target) break;
            count++;
        }
        return count == length;
    }
}

