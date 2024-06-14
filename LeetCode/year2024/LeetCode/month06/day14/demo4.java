package LeetCode.month06.day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/14 14:29
 */
public class demo4 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtracking(nums,0);
        return res;
    }

    public void backtracking(int[] nums, int index) {
        res.add(new ArrayList<>(path));

        for (int i = index; i <nums.length ; i++) {
            if (used[i] || i >0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, i+1);
            used[i] = false;
            path.removeLast();
        }
    }
}

