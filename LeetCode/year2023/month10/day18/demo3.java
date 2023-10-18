package month10.day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/combination-sum/?envType=list&envId=RxT23Yqb
 * @date 2023/10/18 12:15
 */
public class demo3 {
    List<List<Integer>> res;
    LinkedList<Integer> list;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        list = new LinkedList<>();
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return res;
    }

    public void backtracking(int[] candidates, int target, int index) {
        if (target < 0) return;

        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i);
            list.removeLast();
        }
    }
}

