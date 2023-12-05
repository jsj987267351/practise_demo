package month12.day05;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/5 14:04
 */
public class demo2 {
    public int longestValidParentheses(String s) {
        int length = s.length();
        if (length < 2) {
            return 0;
        }
        int[] dp = new int[length];
        int res = 0;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == ')') {
                int preLeftIndex = i - dp[i - 1] - 1;
                if (preLeftIndex >= 0 && s.charAt(preLeftIndex) == '(') {
                    dp[i] = dp[i - 1] + 2;
//                    只有前面的剩余长度还大于一个完整的有效括号时才有可能接上成为更长的有效括号序列
                    if (preLeftIndex >= 2) {
                        dp[i] += dp[preLeftIndex - 1];
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

