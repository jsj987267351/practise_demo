package month11.day12;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/12 14:51
 */
public class demo3 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] -= 2 * nums[i];
                k--;
            } else break;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            res += nums[i];
        }
        if (k == 0 || k % 2 == 0) {
            return res;
        } else {
            return res - 2 * min;
        }
    }
}

