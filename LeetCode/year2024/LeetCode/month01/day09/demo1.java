package LeetCode.month01.day09;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/9 12:19
 */
public class demo1 {
    public int minExtraChar(String s, String[] dictionary) {
        int length = s.length();
        HashSet<String> set = new HashSet<>(Arrays.asList(dictionary));
        int[] dp = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = i - 1; j >= 0; j--) {
                if (set.contains(s.substring(j, i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[length];
    }
}

