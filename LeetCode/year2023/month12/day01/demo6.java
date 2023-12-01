package month12.day01;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/1 13:43
 */
public class demo6 {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder reverse = sb.reverse();
        char[] chars1 = s.toCharArray();
        char[] chars2 = reverse.toString().toCharArray();
        int length = chars1.length;
        int[][] dp = new int[length + 1][length + 1];
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length][length];
    }

    public int longestPalindromeSubseq1(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int[][] dp = new int[length][length];
        for (int i = length - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][length - 1];
    }
}

