package LeetCode.month06.day20;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/20 9:26
 */
public class demo1 {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;
        char[] charArray = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int begin = 0, maxLen = 1;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] == charArray[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public String longestPalindrome1(String s) {
        if (s.length() < 2) return s;
        char[] charArray = s.toCharArray();
        int[] res = new int[2];
        for (int i = 0; i < charArray.length - 1; i++) {
            int[] single = maxLength(charArray, i, i);
            int[] doubles = maxLength(charArray, i, i + 1);
            int[] max = single[1] > doubles[1] ? single : doubles;
            res = max[1] > res[1] ? max : res;
        }
        return s.substring(res[0], res[0] + res[1]);
    }

    public int[] maxLength(char[] chars, int left, int right) {
        while (left >= 0 && right < chars.length) {
            if (chars[left] == chars[right]) {
                left--;
                right++;
            } else break;
        }
        return new int[]{left + 1, right - left - 1};
    }
}

