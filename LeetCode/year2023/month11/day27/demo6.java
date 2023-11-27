package month11.day27;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/27 14:05
 */
public class demo6 {
    List<List<Integer>> res;
    LinkedList<Integer> list;

    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();
        list = new LinkedList<>();
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int startIndex) {
        if (list.size() > 1) {
            res.add(new ArrayList<>(list));
        }
        Set<Integer> set = new HashSet<>();

        for (int i = startIndex; i < nums.length; i++) {
            if (!list.isEmpty() && nums[i] < list.get(list.size()-1) || set.contains(nums[i])) continue;
            list.add(nums[i]);
            set.add(nums[i]);
            backtracking(nums, i + 1);
            list.removeLast();
        }
    }
}

