package month07.day07;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/7 12:33
 */
public class demo1 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int len1 = text1.length();
        int len2 = text2.length();
//        dp[i][j]的含义为下标为0 ~i-1 和 0~j-1 的最长公共子序列
        int[][] dp = new int[len1 + 1][len2 + 1];
//        刚开始初始化所有dp[i][0]和dp[0][j]都为0，可以理解为一个空字符串与另一个字符串的最长公共子序列为0

//        从1开始遍历是因为上面已经说明了第0行和第0列的初始化
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
//                如果当前字符串的前两个字符相等，那么到该字符串前的长度就等于前面的+1
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
//                    如果不相等的话，那么该两个字符串的最大就与前一个相等
//                    举例：abc 和ade  c和e不相等，那么两个字符串的最长有可能是abc和ad的比较  也有可能为ab和ade的比较 取最大值
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

//        这里直接返回数组的最终是因为下标含义为0 ~i-1 和 0~j-1 的最长公共子序列
//        而不一定是一定要以i-1和j-1结尾，所以一定是越长结果越大
        return dp[len1][len2];
    }
}

