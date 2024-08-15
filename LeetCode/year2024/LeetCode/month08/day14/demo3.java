package LeetCode.month08.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/14 10:00
 */
public class demo3 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        DFS(candidates, target, 0);
        return res;
    }

    public void DFS(int[] candidates, int target, int index) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1] || used[i]) continue;
            used[i] = true;
            path.add(candidates[i]);
            DFS(candidates, target - candidates[i], i + 1);
            used[i] = false;
            path.removeLast();
        }
    }
}

