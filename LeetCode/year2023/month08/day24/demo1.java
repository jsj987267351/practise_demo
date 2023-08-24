package month08.day24;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/interleaving-string/?envType=study-plan-v2&envId=top-interview-150
 * @date 2023/8/24 11:40
 */
public class demo1 {
    public boolean isInterleave(String s1, String s2, String s3) {
//            看题解，与不同路径那一题有举一反三的思路
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
//        dp[i][j]含义：用s1的前i个元素与s2前j个元素能否组成s3的前i+j个元素
        boolean[][] dp = new boolean[m + 1][n + 1];
//        两个都空一定能组成空字符串
        dp[0][0] = true;
//        首先进行特判，只用s1的前i个元素能否组成s3的前i个元素，只要有一个不能组成就直接停止，后续都为false
        for (int i = 1; i <= m; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = true;
            } else {
                break;
            }
        }
//         同理
        for (int j = 1; j <= n; j++) {
            if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                dp[0][j] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
//                如果用s1的前i-1个元素与s2的前j个元素能组成s3的前i+j-1个元素，那么s3的前i+j个元素能否组成就看s1的第i个元素与s3的第i+j个预算是否相等
//                s2同理，因为i+j-1  可由i-1与j组成，也可由i与j-1组成
                if (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1) || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[m][n];
    }
}

