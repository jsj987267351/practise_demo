package LeetCode.month07.day01;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/1 10:06
 */
public class demo5 {
    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (charArray1[i - 1] == charArray2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len1][len2];
    }
}

