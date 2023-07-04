package day2023_06_24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/24 16:23
 */
public class demo3 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used, 0);
        return res;
    }


    public void backtracking(int[] nums, boolean[] used, int startIndex) {
        res.add(new ArrayList<>(path));
        if (startIndex >= nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            //    树层去重套路
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, used, i + 1);
            used[i] = false;
            path.removeLast();
        }
    }
}

