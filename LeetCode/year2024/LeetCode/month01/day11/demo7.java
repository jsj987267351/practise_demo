package LeetCode.month01.day11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/11 20:59
 */
public class demo7 {
    int res;

    public int minReorder(int n, int[][] connections) {
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        res = 0;
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            graph[from].add(new int[]{to, 1});
            graph[to].add(new int[]{from, 0});
        }
        dfs(graph, 0, -1);
        return res;
    }

    public void dfs(List<int[]>[] graph, int cur, int parent) {
        for (int[] edge : graph[cur]) {
            if (edge[0] == parent) continue;
            res += edge[1];
            dfs(graph, edge[0], cur);
        }
    }
}

