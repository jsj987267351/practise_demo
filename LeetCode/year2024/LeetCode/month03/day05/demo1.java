package LeetCode.month03.day05;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/5 11:40
 */
public class demo1 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<Integer> graph[] = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        Set<Integer> set = new HashSet<>();
        for (int i : restricted) {
            set.add(i);
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (!set.contains(from) && !set.contains(to)) {
                graph[from].add(to);
                graph[to].add(from);
            }
        }

        return DFS(graph, 0, -1, set);
    }

    public int DFS(List<Integer> graph[], int cur, int from, Set<Integer> set) {
        int count = 1;
        for (int node : graph[cur]) {
            if (node == from) continue;
            count += DFS(graph, node, cur, set);
        }
        return count;
    }
}

