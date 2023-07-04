package day2023_06_24;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * <p>
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/non-decreasing-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/24 16:32
 */
public class demo4 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    public void backtracking(int[] nums, int startIndex) {
//        只要子集里数量超过1就可以进行收集了，
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
//            这里不能return，因为后续还会取
        }

//        因为要树层去重，但是不能排序，所以不能使用解决子集的去重操作，这里使用set集合来记录当前层取过的数字来达到去重效果。
//        因为每次递归都会创建新的set集合，所以当前set集合就是记录当前层所取过的数字
        Set<Integer> set = new HashSet<>();

        for (int i = startIndex; i < nums.length; i++) {
//            如果当前数字小于path中最后一位数字的话，直接跳过。因为无法达成递增序列，并且要达到树层去重，所以也要判断set中是否存在
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || set.contains(nums[i])) continue;
//            这里set没有用回溯，是因为每层都是递归创建新的set集合，当前set集合就是记录当前层的数字
            set.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }

//    //    使用map同理
//    public void backtracking(int[] nums, int startIndex) {
//
//        if (path.size() >= 2) {
//            res.add(new ArrayList<>(path));
//        }
//
////    key：当前数字  value:取过多少次
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for (int i = startIndex; i < nums.length; i++) {
//
//            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) || map.getOrDefault(nums[i], 0) > 0) continue;
//
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//            path.add(nums[i]);
//            backtracking(nums, i + 1);
//            path.removeLast();
//        }
//    }
}

