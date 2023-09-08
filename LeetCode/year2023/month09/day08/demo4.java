package month09.day08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/8 15:23
 */
public class demo4 {
    List<List<Integer>> res;
    LinkedList<Integer> path;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        path = new LinkedList<>();
        backtracking(nums, 0);
        return res;
    }

    public void backtracking(int[] nums, int index) {
        res.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
        return;
    }
}

