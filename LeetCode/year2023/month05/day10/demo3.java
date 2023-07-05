package month05.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/5/10 16:55
 */
public class demo3 {
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        backtracking1(result, list, target, candidates, 0, 0);
        return result;

    }

    public void backtracking1(List<List<Integer>> result, LinkedList<Integer> list, int target, int[] candidates, int sum, int index) {

        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            sum += candidates[i];
            backtracking1(result, list, target, candidates, sum, i);
            sum -= candidates[i];
            list.removeLast();
        }
    }

    /***
     * @description 分界线---------------------------------------------------------------------
     */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int length = candidates.length;
        List<List<Integer>> result = new ArrayList<>();

        LinkedList<Integer> list = new LinkedList<>();

        Arrays.sort(candidates);
        backtracking(result, list, target, candidates, 0, length);
        return result;

    }

    public void backtracking(List<List<Integer>> result, LinkedList<Integer> list, int target, int[] candidates, int index, int length) {

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < length; i++) {
            if (target - candidates[i] < 0) break;
            list.add(candidates[i]);
            backtracking(result, list, target - candidates[i], candidates, i, length);
            list.removeLast();
        }
    }
}

