package month07.day11;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * <p>
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/11 14:54
 */
public class demo3 {
    public int longestPalindromeSubseq1(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();

//        dp[i][j]含义：在i~j区间（左右都闭区间）的最长回文字串长度
        int[][] dp = new int[length][length];

//        初始化的话，是所有的dp[i][i]都初始化为1，因为所有的单个字符都是回文子串，并且长度为1
//        而且根据下方递推公式可以发现i和j都是往中间的，所以初始化对角线

//        因为 dp[i][j] 由  dp[i + 1][j - 1] ，dp[i + 1][j] ， dp[i][j - 1]三个方向推导而来
//        也就是左下，左边和下边。所以需要从下往上，从左往右遍历
        for (int i = length - 1; i >= 0; i--) {
//            在这里进行初始化，也可以单独初始化
            dp[i][i] = 1;
//            j从i+1开始遍历，因为j要大于等于i下标才符合，而且j==i的情况已经初始化了，所以直接i+1开始遍历
            for (int j = i + 1; j < length; j++) {
                if (chars[i] == chars[j]) {
//                    如果当前两个字符相等的话，那么以该两个字符为左右闭区间的最长回文子串长度就是在其分别前进一位的最长+2
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
//                    不等的话，就分别只让其中一个前进一位取最大值
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

//        最后返回从下标0到 length-1 也就是整个字符串的最长回文子序列长度
        return dp[0][length - 1];
    }


    public int longestPalindromeSubseq(String s) {
//         直接求s和s.reverse的最长公共子序列即可
        StringBuilder stringBuilder = new StringBuilder(s);
        String reverse = stringBuilder.reverse().toString();
        char[] chars = s.toCharArray();
        char[] chars1 = reverse.toCharArray();
        int length = s.length();
        int[][] dp = new int[length + 1][length + 1];


        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                if (chars[i - 1] == chars1[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[length][length];
    }
}

