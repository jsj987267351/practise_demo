package LeetCode.month07.day26;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/26 9:40
 */
public class demo2 {
    public int countPaths(int n, int[][] roads) {
        int mod = (int) 1e9 + 7;
        long[][] gra = new long[n][n];
        for (long[] longs : gra) {
            Arrays.fill(longs, Long.MAX_VALUE / 2);
        }
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int len = road[2];
            gra[a][b] = len;
            gra[b][a] = len;
        }
        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE / 2);
        dis[0] = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        boolean[] used = new boolean[n];
        while (true) {
            int min = -1;
            for (int i = 0; i < n; i++) {
                if (!used[i] && (min < 0 || dis[i] < dis[min])) {
                    min = i;
                }
            }
            if (min == n - 1) {
                return dp[min];
            }
            used[min] = true;
            for (int i = 0; i < n; i++) {
                if (dis[min] + gra[min][i] < dis[i]) {
                    dis[i] = dis[min] + gra[min][i];
                    dp[i] = dp[min];
                } else if (dis[min] + gra[min][i] == dis[i]) {
                    dp[i] = (dp[i] + dp[min]) % mod;
                }
            }
        }
    }
}

