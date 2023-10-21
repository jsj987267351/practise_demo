package month10.day21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/21 12:32
 */
public class demo1 {
    List<List<Integer>> res;
    LinkedList<Integer> list;
    boolean used[];

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        list = new LinkedList<>();
        used = new boolean[nums.length];
        backtracking(nums);
        return res;
    }

    public void backtracking(int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            list.add(nums[i]);
            used[i] = true;
            backtracking(nums);
            used[i] = false;
            list.removeLast();
        }
    }
}

