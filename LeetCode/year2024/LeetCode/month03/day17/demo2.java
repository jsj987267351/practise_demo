package LeetCode.month03.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/17 16:19
 */
public class demo2 {
    public long maxArrayValue(int[] nums) {
        long res = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
//            像那个墙一样，会挡住后续所有
            res = nums[i] > res ? nums[i] : nums[i] + res;
        }
        return res;
    }
}

