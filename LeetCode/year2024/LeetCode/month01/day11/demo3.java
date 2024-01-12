package LeetCode.month01.day11;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/11 14:49
 */
public class demo3 {
    long res = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        int length = roads.length;
        List<Integer> graph[] = new ArrayList[length + 1];
        for (int i = 0; i <= length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        dfs(graph, 0, -1, seats);
        return res;
    }

    public int dfs(List<Integer> graph[], int cur, int parent, int seats) {
        int total = 1;
        for (int from : graph[cur]) {
            if (from == parent) continue;
            int curTotal = dfs(graph, from, cur, seats);
            total += curTotal;
            int need = curTotal % seats == 0 ? curTotal / seats : curTotal / seats + 1;
            res += need;
        }
        return total;
    }
}

