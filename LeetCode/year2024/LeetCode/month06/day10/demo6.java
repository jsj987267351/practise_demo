package LeetCode.month06.day10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/10 17:03
 */
public class demo6 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, res = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[right]) {
                res = Math.min(res, nums[mid]);
                right = mid - 1;
            } else if (nums[mid] >= nums[left]) {
                res = Math.min(res, nums[left]);
                left = mid + 1;
            }
        }
        return res;
    }
}

