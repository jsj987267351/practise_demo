package LeetCode.month07.day16;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/16 10:55
 */
public class demo8 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] dp = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            int[] cur = trips[i];
            dp[cur[1]] -= cur[0];
            dp[cur[2]] += cur[0];
        }
        for (int i = 0; i < dp.length; i++) {
            capacity += dp[i];
            if (capacity < 0)
                return false;
        }
        return true;
    }
}

