package month12.day07;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/7 13:33
 */
public class demo1 {
    public int minReorder(int n, int[][] connections) {
//        看官方解析
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            int start = connection[0];
            int end = connection[1];
            graph[start].add(new int[]{end, 1});
            graph[end].add(new int[]{start, 0});
        }
        return dfs(0, -1, graph);
    }

    private int dfs(int cur, int parent, List<int[]>[] graph) {
        int res = 0;
        for (int[] edge : graph[cur]) {
            if (edge[0] == parent) {
                continue;
            }
            res += edge[1] + dfs(edge[0], cur, graph);
        }
        return res;
    }
}

