package month10.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/combination-sum-ii/?envType=list&envId=hliQiQFH
 * @date 2023/10/9 11:55
 */
public class demo2 {
    List<List<Integer>> res;
    LinkedList<Integer> list;
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        used = new boolean[candidates.length];
        list = new LinkedList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return res;
    }

    public void backtracking(int[] candidates, int target, int startIndex) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;
            list.add(candidates[i]);
            used[i] = true;
            backtracking(candidates, target - candidates[i], i + 1);
            used[i] = false;
            list.removeLast();
        }
    }
}

