package LeetCode.month06.day20;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/20 11:15
 */
public class demo9 {
    public int maxAbsoluteSum(int[] nums) {
        int len = nums.length;
        int[] maxDp = new int[len];
        maxDp[0] = nums[0];
        int[] minDp = new int[len];
        minDp[0] = nums[0];
        int max = nums[0],min = nums[0];
        for (int i = 1; i < len; i++) {
            maxDp[i] = Math.max(maxDp[i - 1] + nums[i], nums[i]);
            minDp[i] = Math.min(minDp[i - 1] + nums[i], nums[i]);
            max = Math.max(maxDp[i],max);
            min = Math.min(minDp[i],min);
        }
        return Math.max(max, Math.abs(min));
    }
}

