package LeetCode.month04.day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/4 11:42
 */
public class demo {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
//        gra[i]表示所有可以直接到达i的节点,也就是说例表中的所有节点i都可以直接到达
        List<Integer> gra[] = new ArrayList[n];
        Arrays.setAll(gra,ArrayList::new);
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            gra[to].add(from);
        }
//        存储结果
        List<Integer> res[] = new ArrayList[n];
         Arrays.setAll(res,ArrayList::new);
//        记录从每个节点触发后当前节点是否能访问到
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
//            每次初始化used数组
            Arrays.fill(used, false);
            DFS(i, gra, used);
//            节点本身不算自身的祖宗节点，所以重置
            used[i] = false;
            for (int j = 0; j < n; j++) {
                if (used[j]) {
                    res[i].add(j);
                }
            }
        }
        return Arrays.asList(res);
    }

    public void DFS(int cur, List<Integer> gra[], boolean[] used) {
        used[cur] = true;
//        遍历当前节点所有可以访问的节点
        for (int can : gra[cur]) {
            if (!used[can]) {
                DFS(can, gra, used);
            }
        }
    }
}

