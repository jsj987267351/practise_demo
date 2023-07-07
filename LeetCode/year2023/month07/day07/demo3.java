package month07.day07;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/7 13:16
 */
public class demo3 {
    public boolean isSubsequence1(String s, String t) {
//        就是求最长公共子序列，然后只要两个的最长公共子序列的长度是s的长度的化，那么就可以
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int length1 = s.length();
        int length2 = t.length();

        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (chars[i - 1] == chart[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[length1][length2] == length1;
    }

    public boolean isSubsequence(String s, String t) {
//        双指针
        int p = 0, q = 0;
        while (p < s.length() && q < t.length()) {
            if (s.charAt(p) == t.charAt(q)) {
                p++;
            }
            q++;
        }
        return p == s.length();
    }
}

