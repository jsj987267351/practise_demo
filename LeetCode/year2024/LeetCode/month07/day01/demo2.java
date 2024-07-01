package LeetCode.month07.day01;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/1 9:38
 */
public class demo2 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();


    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    public void backtracking(int[] nums, int index) {
        if (path.size() >= 2 ) {
            res.add(new ArrayList<>(path));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
           if (set.contains(nums[i]) || !path.isEmpty() && nums[i] < path.getLast()) continue;
           set.add(nums[i]);
           path.addLast(nums[i]);
           backtracking(nums, i + 1);
           path.removeLast();
        }
    }
}

