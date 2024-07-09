package LeetCode.month07.day09;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/9 9:26
 */
public class demo1 {
    public int respace(String[] dictionary, String sentence) {
        int len = sentence.length();
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + 1;
            for (String s : dictionary) {
                int length = s.length();
                if (i >= length && s.equals(sentence.substring(i - length, i))) {
                    dp[i] = Math.min(dp[i], dp[i - length]);
                }
            }
        }
        return dp[len];
    }

    public int respace1(String[] dictionary, String sentence) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int len = sentence.length();
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                if (set.contains(sentence.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[len];
    }
}

