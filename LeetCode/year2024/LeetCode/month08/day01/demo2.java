package LeetCode.month08.day01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/1 9:28
 */
public class demo2 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer> g[] = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        Set<Integer> set = new HashSet<>();
        for (int i : restricted) {
            set.add(i);
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (!set.contains(from) && !set.contains(to)) {
                g[from].add(to);
                g[to].add(from);
            }
        }
        return DFS(g, 0, -1);
    }

    public int DFS(List<Integer> g[], int cur, int parent) {
        int count = 1;
        for (Integer i : g[cur]) {
            if (i == parent) continue;
            count += DFS(g, i, cur);
        }
        return count;
    }
}

