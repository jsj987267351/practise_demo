package LeetCode.month06.day20;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/20 10:45
 */
public class demo7 {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (charArray1[i - 1] == charArray2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

//    不知道为什么这个写法错误
//    public int longestCommonSubsequence1(String text1, String text2) {
//        int len1 = text1.length();
//        int len2 = text2.length();
//        char[] charArray1 = text1.toCharArray();
//        char[] charArray2 = text2.toCharArray();
//        int[][] dp = new int[len1][len2];
//        for (int i = 0; i < len1; i++) {
//            if (charArray2[0] == charArray1[i]) {
//                dp[i][0] = 1;
//            }
//        }
//        for (int i = 0; i < len2; i++) {
//            if (charArray1[0] == charArray2[i]) {
//                dp[0][i] = 1;
//            }
//        }
//        for (int i = 1; i < len1; i++) {
//            for (int j = 1; j < len2; j++) {
//                if (charArray1[i] == charArray2[j]) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                }
//            }
//        }
//        return dp[len1 - 1][len2 - 1];
//    }
}

