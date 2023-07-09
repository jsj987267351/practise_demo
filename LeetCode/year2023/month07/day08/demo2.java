package month07.day08;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 * <p>
 * 每步 可以删除任意一个字符串中的一个字符。
 * <p>
 * https://leetcode.cn/problems/delete-operation-for-two-strings/
 * @date 2023/7/8 20:19
 */
public class demo2 {
    public int minDistance(String word1, String word2) {
//        求最长公共子序列即可,然后两边都减去最长公共子序列的长度
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int length1 = chars1.length;
        int length2 = chars2.length;

        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        int length = dp[length1][length2];
        return length1 - length + (length2 - length);
    }
}

