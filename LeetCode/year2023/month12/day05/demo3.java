package month12.day05;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/5 14:14
 */
public class demo3 {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = nums[0], max = nums[0], CurMax = nums[0], min = nums[0], CurMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            CurMax = Math.max(CurMax + nums[i], nums[i]);
            max = Math.max(max, CurMax);
            CurMin = Math.min(CurMin + nums[i], nums[i]);
            min = Math.min(min, CurMin);
            sum += nums[i];
        }
        return max > 0 ? Math.max(max, sum - min) : max;
    }
}

