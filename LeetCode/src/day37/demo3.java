package day37;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * https://leetcode.cn/problems/TVdhkn/
 * @date 2023/5/8 17:20
 */
public class demo3 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();

        backtracking(result, path, nums, 0);
        return result;
    }

    public void backtracking(List<List<Integer>> result, LinkedList<Integer> path, int[] nums, int startIndex) {

        result.add(new ArrayList<>(path));


        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(result, path, nums, i + 1);
            path.removeLast();
        }

        return;
    }
}

