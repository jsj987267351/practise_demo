package LeetCode.month05.day31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/31 11:55
 */
public class demo4 {
    private static List<List<Integer>> res;
    private static LinkedList<Integer> path;
    private static boolean[] used;
    private static int len;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        len = nums.length;
        used = new boolean[len];
        res = new ArrayList<>();
        path = new LinkedList<>();
        backtracking(nums);
        return res;
    }

    public void backtracking(int[] nums) {
        if (path.size() == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            path.addLast(nums[i]);
            used[i] = true;
            backtracking(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}

