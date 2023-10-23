package month10.day23;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/23 13:04
 */
public class demo4 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, curSum = 0, min = Integer.MAX_VALUE;
        while (right < nums.length) {
            curSum += nums[right];
            right++;
            while (curSum >= target) {
                min = Math.min(min, right - left);
                curSum -= nums[left];
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

