package LeetCode.month03.day05;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/5 11:54
 */
public class demo2 {
    public int countPaths(int n, int[][] roads) {
        int mod = 1_000_000_007;
//        graph[i][j]表示从i到j的路径长度
        long[][] graph = new long[n][n];
//        初始为最大值一半，防止溢出
        for (long[] row : graph) {
            Arrays.fill(row, Long.MAX_VALUE / 2);
        }
        for (int[] road : roads) {
            int a = road[0];
            int b = road[1];
            int len = road[2];
            graph[a][b] = len;
            graph[b][a] = len;
        }
//        dis[i]表示从0到i的最少时间为多少，初始除了0到0为0，其余都设置最大值
        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE / 2);
        dis[0] = 0;
//        dp[i]表示从0到1的最少时间的路径数目，初始0到0为一条路径，其余初始化0，后续遍历不断叠加
        int[] dp = new int[n];
        dp[0] = 1;
//        表示当前节点是否已经确定过了最小路径值
        boolean[] used = new boolean[n];
        while (true) {
//            当前从0出发能到达的最小节点索引
            int min = -1;
            for (int i = 0; i < n; i++) {
                if (!used[i] && (min < 0 || dis[i] < dis[min])) {
                    min = i;
                }
            }
//            此时的min就是在已经确定值之后的最小节点,如果已经到达了目的节点，就可以直接返回dp[min]了
//            因为dp在更新路径值中已经也在更新了
            if (min == n - 1) {
                return dp[min];
            }
            used[min] = true;
//            开始从当前最小节点继续往下更新
            for (int i = 0; i < n; i++) {
                long newDis = dis[min] + graph[min][i];
                if (newDis < dis[i]) {
                    dis[i] = newDis;
                    dp[i] = dp[min];
                } else if (newDis == dis[i]) {
                    dp[i] = (dp[i] + dp[min]) % mod;
                }
            }
        }
    }
}

