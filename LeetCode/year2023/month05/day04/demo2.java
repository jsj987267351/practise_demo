package month05.day04;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 * @date 2023/5/4 15:28
 */
public class demo2 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        int j = nums.length - 1;
        if (nums.length <1 ||nums[0] > target || nums[j] < target ) {
            return result;
        }
        int i = 0;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (nums[m] <target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        if (nums[j+1]!=target){
            return result;
        }
        result[0] = j + 1;
        for (int k = j+1; k < nums.length; k++) {
            if (nums[k] != target) {
                result[1] = k - 1;
                break;
            }
        }
        if (result[1] ==-1){
            result[1] = nums.length-1;
        }
        return result;
    }
}

