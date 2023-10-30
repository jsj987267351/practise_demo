package month10.day30;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/30 12:00
 */
public class demo3 {

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) return s;
        char[] chars = s.toCharArray();
        int[] res = new int[2];
        for (int i = 0; i < length - 1; i++) {
            int[] single = BroadFromCenter(chars, i, i);
            int[] doubles = BroadFromCenter(chars, i, i + 1);
            int[] max = doubles[1] > single[1] ? doubles : single;
            res = res[1] > max[1] ? res : max;
        }
        return s.substring(res[0], res[0] + res[1]);
    }

    public int[] BroadFromCenter(char[] chars, int left, int right) {
        int length = chars.length;
        while (left >= 0 && right < length) {
            if (chars[left] == chars[right]) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return new int[]{left + 1, right - left - 1};
    }


    public String longestPalindrome1(String s) {
        int length = s.length();
        if (length < 2) return s;
        char[] chars = s.toCharArray();
        int maxLength = 1, begin = 0;
        boolean[][] dp = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else if (j - i < 3) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLength);
    }
}

