package LeetCode.month05.day31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/31 13:03
 */
public class demo5 {
    private static List<List<Integer>> res;
    private static LinkedList<Integer> path;
    private static boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        path = new LinkedList<>();
        used = new boolean[candidates.length];
        backtracking(candidates, target, 0);
        return res;
    }

    public void backtracking(int[] candidates, int target, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (used[i] || i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            path.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i + 1);
            used[i] = false;
            path.removeLast();
        }
    }
}

