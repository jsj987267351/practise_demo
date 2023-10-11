package month10.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/permutations-ii/?envType=list&envId=hliQiQFH
 * @date 2023/10/11 12:14
 */
public class demo3 {
    List<List<Integer>> res;
    LinkedList<Integer> list;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        list = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used);
        return res;
    }

    public void backtracking(int[] nums, boolean[] used) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1] || used[i])
                continue;
            list.add(nums[i]);
            used[i] = true;
            backtracking(nums, used);
            list.removeLast();
            used[i] = false;
        }
    }
}

