package LeetCode.month07.day17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/17 9:56
 */
public class demo2 {
    public long maxTaxiEarnings(int n, int[][] rides) {
        long[] dp = new long[n + 1];
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] ride : rides) {
            int end = ride[1];
            if (!map.containsKey(end)){
                map.put(end, new ArrayList<>());
            }
            map.get(end).add(ride);
        }
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            for (int[] road : map.getOrDefault(i, new ArrayList<>())) {
                dp[i] = Math.max(dp[i], road[1] - road[0] + road[2] + dp[road[0]]);
            }
        }
        return dp[n];
    }
}

