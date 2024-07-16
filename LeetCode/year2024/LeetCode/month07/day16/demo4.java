package LeetCode.month07.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/16 10:06
 */
public class demo4 {
    long res = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        int len = roads.length;
        List<Integer> g[] = new ArrayList[len + 1];
        for (int i = 0; i <= len; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < len; i++) {
            int from = roads[i][0];
            int to = roads[i][1];
            g[from].add(to);
            g[to].add(from);
        }
        dfs(g, 0, -1, seats);
        return res;
    }

    public int dfs(List<Integer> g[], int cur, int parent, int seats) {
        int totalPeople = 1;
        for (int from : g[cur]) {
            if (from == parent) continue;
            int people = dfs(g, from, cur, seats);
            totalPeople += people;
            int cost = people % seats == 0 ? people / seats : people / seats + 1;
            res += cost;
        }
        return totalPeople;
    }
}

