package LeetCode.month08.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/13 9:28
 */
public class demo2 {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, ArrayList::new);
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            g[to].add(from);
        }
        List<Integer>[] res = new ArrayList[n];
        Arrays.setAll(res, ArrayList::new);
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(used, false);
            DFS(i, g, used);
            used[i] = false;
            for (int j = 0; j < n; j++) {
                if (used[j]) {
                    res[i].add(j);
                }
            }
        }
        return Arrays.asList(res);
    }

    public void DFS(int cur, List<Integer>[] g, boolean[] used) {
        used[cur] = true;
        for (Integer can : g[cur]) {
            if (!used[can]) {
                DFS(can, g, used);
            }
        }
    }
}

