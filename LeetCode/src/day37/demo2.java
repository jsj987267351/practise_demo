package day37;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。
 * https://leetcode.cn/problems/VvJkup/
 * @date 2023/5/8 17:12
 */
public class demo2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(result,path,nums,used);

        return result;

    }


    public void backtracking(List<List<Integer>> result,LinkedList<Integer> path,int[] nums,boolean[] used){

        if (path.size()== nums.length){
            result.add(new ArrayList<>(path));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtracking(result,path,nums,used);

            used[i] = false;
            path.removeLast();
        }
    }
}

