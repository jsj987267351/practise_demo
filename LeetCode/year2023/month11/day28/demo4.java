package month11.day28;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/28 14:31
 */
public class demo4 {
    public int numDistinct(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[length1][length2];
    }
}

