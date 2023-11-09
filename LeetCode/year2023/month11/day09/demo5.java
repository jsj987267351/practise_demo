package month11.day09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/9 13:05
 */
public class demo5 {
    List<List<Integer>> res;
    LinkedList<Integer> list;
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        list = new LinkedList<>();
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums, 0);
        return res;
    }

    public void backtracking(int[] nums, int startIndex) {
        res.add(new ArrayList<>(list));

        for (int i = startIndex; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            used[i] = true;
            list.add(nums[i]);
            backtracking(nums, i + 1);
            used[i] = false;
            list.removeLast();
        }
    }
}

