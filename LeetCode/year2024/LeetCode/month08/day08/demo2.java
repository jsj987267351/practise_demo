package LeetCode.month08.day08;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/8 17:31
 */
public class demo2 {
    public int maximumCount(int[] nums) {
        int left = findIndex(nums, 0);
        int right = nums.length - findIndex(nums, 1);
        return Math.max(left, right);
    }

    public int findIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

