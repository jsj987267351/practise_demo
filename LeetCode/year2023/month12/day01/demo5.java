package month12.day01;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/1 13:09
 */
public class demo5 {
    public int countSubstrings(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int center = 0; center < length * 2 - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < length && chars[left] == chars[right]) {
                res++;
                left--;
                right++;
            }
        }
        return res;
    }

    public int countSubstrings1(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        int length = chars.length;
        boolean[][] dp = new boolean[length][length];
        for (int row = length - 1; row >= 0; row--) {
            for (int col = row; col < length; col++) {
                if (chars[row] == chars[col]) {
                    if (col - row < 2 || dp[row + 1][col - 1]) {
                        dp[row][col] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}

