package LeetCode.month08.day09;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/9 10:08
 */
public class demo1 {
    public int maximumScore(int[] nums, int k) {
        int res = nums[k], min = nums[k];
        int left = k, right = k;
        for (int i = 0; i < nums.length - 1; i++) {
            if (right == nums.length - 1 || left > 0 && nums[left - 1] > nums[right + 1]) {
                left--;
                min = Math.min(min, nums[left]);
            } else {
                right++;
                min = Math.min(min, nums[right]);
            }
            res = Math.max(res, min * (right - left + 1));
        }
        return res;
    }
}

