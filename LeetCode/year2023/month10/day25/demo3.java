package month10.day25;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/subsets/?envType=list&envId=hliQiQFH
 * @date 2023/10/25 16:29
 */
public class demo3 {
    List<List<Integer>> res;
    LinkedList<Integer> list;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        list = new LinkedList<>();
        backtracking(nums, 0);
        return res;
    }

    public void backtracking(int[] nums, int startIndex) {
        res.add(new ArrayList<>(list));

        for (int i = startIndex; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(nums, i + 1);
            list.removeLast();
        }

    }
}

