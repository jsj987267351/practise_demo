package LeetCode.month07.day09;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/9 10:25
 */
public class demo6 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int res = 0;
        for (int i = 0; i < nums.length; ) {
            if (nums[i] % 2 != 0 || nums[i] > threshold) {
                i++;
                continue;
            }
            int len = 1;
            i++;
            while (i < nums.length && nums[i] % 2 != nums[i - 1] % 2 && nums[i] <= threshold) {
                len++;
                i++;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}

