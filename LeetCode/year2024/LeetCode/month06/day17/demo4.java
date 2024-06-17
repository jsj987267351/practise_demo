package LeetCode.month06.day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/17 14:09
 */
public class demo4 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return res;
    }

    public void backtracking(int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) return;
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i);
            path.removeLast();
        }
    }
}

