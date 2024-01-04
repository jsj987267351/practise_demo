package LeetCode.month01.day04;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/4 13:06
 */
public class demo3 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int length = nums.length;
        int index = 0, res = 0;
        while (index < length) {
            if (nums[index] % 2 == 0 && nums[index] <= threshold) {
                index++;
                int count = 1;
                while (index < length && nums[index] <= threshold && nums[index] % 2 != nums[index - 1] % 2) {
                    index++;
                    count++;
                }
                res = Math.max(res, count);
            } else {
                index++;
            }
        }
        return res;
    }
}

