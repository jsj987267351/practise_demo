package day2023_05_24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * https://leetcode.cn/problems/permutations-ii/
 * @date 2023/5/24 17:44
 */
public class demo4 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(result, temp, nums, used);

        return result;
    }

    public void backtracking(List<List<Integer>> result, LinkedList<Integer> temp, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
//            取过了，直接跳过
            if (used[i]) continue;
//            同树层上如果当前取得值与前一个相同则跳过，去重作用
            if (i>0 && nums[i] == nums[i-1] && !used[i-1]) continue;
//            可取
            temp.add(nums[i]);
            used[i] = true;
            backtracking(result,temp,nums,used);
//            回溯
            used[i] =false;
            temp.removeLast();
        }
    }

}

