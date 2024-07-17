package LeetCode.month07.day17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/17 9:34
 */
public class demo1 {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            int start = connection[0];
            int end = connection[1];
            g[start].add(new int[]{end, 1});
            g[end].add(new int[]{start, 0});
        }
        return dfs(g, 0, -1);
    }

    private int dfs(List<int[]>[] g, int cur, int parent) {
        int res = 0;
        for (int[] road : g[cur]) {
            if (road[0] == parent) continue;
            res += road[1] + dfs(g, road[0], cur);
        }
        return res;
    }
}

