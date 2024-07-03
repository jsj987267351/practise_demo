package LeetCode.month07.day03;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/3 9:44
 */
public class demo3 {
    public int longestValidParentheses(String s) {
        int length = s.length();
        if (length < 2) return 0;
        char[] charArray = s.toCharArray();
        int res = 0;
        int[] dp = new int[length];
        for (int i = 1; i < length; i++) {
            if (charArray[i] == ')') {
                int preIndex = i - dp[i - 1] - 1;
                if (preIndex >= 0 && charArray[preIndex] == '(') {
                    dp[i] = dp[i - 1] + 2;
                    if (preIndex > 0) {
                        dp[i] += dp[preIndex - 1];
                    }
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}

