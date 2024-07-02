package LeetCode.month07.day02;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/2 10:00
 */
public class demo4 {
    public int longestPalindromeSubseq1(String s) {
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = new StringBuilder(s).reverse().toString().toCharArray();
        int length = s.length();
        int[][] dp = new int[length + 1][length + 1];
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                if (charArray1[i - 1] == charArray2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length][length];
    }

    public int longestPalindromeSubseq(String s) {
        char[] charArray = s.toCharArray();
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (charArray[i] == charArray[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][len - 1];
    }
}

