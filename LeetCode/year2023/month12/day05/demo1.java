package month12.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/5 13:24
 */
public class demo1 {
    long res = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
//        看官解
        int length = roads.length;
//        表示每个节点的邻接图，graph[i]表示可以到达节点 i 的所有节点，长度为length+1 是因为题目给n-1条路，两两相连代表有n个节点
        List<Integer> graph[] = new ArrayList[length + 1];
//        初始化邻接表
        for (int i = 0; i <= length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
//            from可到达to，to也可到达from
            graph[from].add(to);
            graph[to].add(from);
        }
//        直接求得以0节点为父节点一共有多少到达，计算途中就求出结果
        dfs(graph, 0, -1, seats);
        return res;
    }

    //    cur表示当前节点，parent表示当前节点的父节点
//    该函数是求cur有多少个子节点，也就是会有多少人路过该节点
    public int dfs(List<Integer> graph[], int cur, int parent, int seats) {
//        首先该节点本身就有一个人
        int totalPeople = 1;
//        遍历所有能到达当前节点的邻接节点，即子节点
        for (int from : graph[cur]) {
//            如果邻接节点是父节点的话直接跳过，因为只求单向到达该节点的，该节点会继续向上到父节点
            if (from == parent) continue;
//            继续以当前节点为父节点进行深搜
            int curPeople = dfs(graph, from, cur, seats);
//            父节点总数加上当前节点的路过人数
            totalPeople += curPeople;
//            计算通过子节点到达该父节点需要的燃料，要向上取整
            int cost = (curPeople + seats - 1) / seats;
//            加到最终结果中
            res += cost;
        }
        return totalPeople;
    }
}

