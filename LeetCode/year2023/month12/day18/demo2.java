package month12.day18;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/18 14:22
 */
public class demo2 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int length1 = s1.length();
        int length2 = s2.length();
        int length3 = s3.length();
        if (length1 + length2 != length3) {
            return false;
        }
        boolean[][] dp = new boolean[length1 + 1][length2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= length1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
            } else break;
        }
        for (int i = 1; i <= length2; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[0][i] = true;
            } else break;
        }
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[length1][length2];
    }
}

