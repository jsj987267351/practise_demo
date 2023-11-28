package month11.day28;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/28 14:52
 */
public class demo6 {
    public int maxAbsoluteSum(int[] nums) {
        int length = nums.length;
        int[] dpMin = new int[length];
        int[] dpMax = new int[length];
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];
        for (int i = 1; i < length; i++) {
            if (dpMin[i - 1] > 0) {
                dpMin[i] = nums[i];
            } else {
                dpMin[i] = dpMin[i - 1] + nums[i];
            }

            if (dpMax[i - 1] < 0) {
                dpMax[i] = nums[i];
            } else {
                dpMax[i] = dpMax[i - 1] + nums[i];
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            res = Math.max(res, Math.max(Math.abs(dpMax[i]), Math.abs(dpMin[i])));
        }
        return res;
    }
}

