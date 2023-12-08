package month12.day08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/8 13:16
 */
public class demo1 {
    public long maxTaxiEarnings(int n, int[][] rides) {
//        dp[i]表示到达地点i时的最大盈利,dp[0]=0
        long[] dp = new long[n + 1];
//        key为终点，value为以当前key为终点的所有乘客
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] ride : rides) {
            int end = ride[1];
            map.putIfAbsent(end, new ArrayList<>());
            map.get(end).add(ride);
        }
//        从头开始遍历每个节点为终点的时候
        for (int i = 1; i <= n; i++) {
//            初始dp[i]的最大值为dp[i-1]，因为可能没有乘客以当前点为终点，那么最大值就是以前一个点为终点的最大值
            dp[i] = dp[i - 1];
//            遍历所有以当前地点为终点的乘客,people[1] - people[0] + people[2] + dp[people[0]表示该乘客的利益
//            总利益等于当前节点的利益+接上该乘客之前的利益，也就是在该乘客上车时已经获得的利益
            for (int[] people : map.getOrDefault(i, new ArrayList<>())) {
                dp[i] = Math.max(dp[i], people[1] - people[0] + people[2] + dp[people[0]]);
            }
        }
        return dp[n];
    }
}

