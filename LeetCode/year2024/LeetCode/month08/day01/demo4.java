package LeetCode.month08.day01;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/1 9:41
 */
public class demo4 {
    public long maxArrayValue(int[] nums) {
        long res = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > res) {
                res = nums[i];
            } else {
                res += nums[i];
            }
        }
        return res;
    }
}

