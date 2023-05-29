package day52;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。 
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/5/29 17:06
 */
public class demo4 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backtracking(list, linkedList, candidates, target, 0, 0, used);
        return list;

    }

    public void backtracking(List<List<Integer>> list, LinkedList<Integer> linkedList, int[] candidates, int target, int startIndex, int sum, boolean[] used) {
//        因为都是正数，所以只要和大于0了，后续就没必要继续了，直接返回
        if (sum > target) return;
        if (sum == target) {
//            找到
            list.add(new ArrayList<>(linkedList));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
//            树层去重,如果与前一个取值相等或者直接跳过了前一个直接取当前都剪枝
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) continue;
            linkedList.add(candidates[i]);
            sum += candidates[i];
            used[i] = true;
            backtracking(list, linkedList, candidates, target, i + 1, sum, used);
            linkedList.removeLast();
            sum -= candidates[i];
            used[i] = false;
        }
    }
}

