package day10;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * @date 2023/3/26 15:42
 */
public class demo1 {
    public int[] sortedSquares1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}

