package month07.day14;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * https://leetcode.cn/problems/longest-valid-parentheses/
 * @date 2023/7/14 17:01
 */
public class demo2 {
    public int longestValidParentheses(String s) {
        int length = s.length();
        if (length < 2) {
            return 0;
        }
        int max = 0;
//        动态规划：dp[i]表示以i下标结尾的最长有效括号长度
        int[] dp = new int[length];
        for (int i = 1; i < length; i++) {
//            如果当前位置为右括号，那么就去找左边第一个可能未被匹配的左括号
            if (s.charAt(i) == ')') {
//                当前下标左边第一个可能未被匹配的左括号的下标就是 减去当前位置前一个匹配完的长度 的前一个
//                举例：（  （）（）（）  ）  那么右边括号的左边第一个未被匹配的括号就要以前面结尾的占地长度，因为在他的长度内都是匹配完成的
                int pre = i - dp[i - 1] - 1;
//                判断当前下标是否合法并且是否是左括号
                if (pre >= 0 && s.charAt(pre) == '(') {
//                    如果是左括号的话，那么以当前下标结尾的最长有效括号就是前一个的长度+2，也就是左右各加一个左右括号
                    dp[i] = dp[i - 1] + 2;
//                    继续加上新匹配的左括号的前一位的长度
//                    因为匹配上当前左括号后，以左括号的前一位为结尾的有效括号就有可能与我们新匹配的脸上一起
                    if (pre > 0) {
                        dp[i] += dp[pre - 1];
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

