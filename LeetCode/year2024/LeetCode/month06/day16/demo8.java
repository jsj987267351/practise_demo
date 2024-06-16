package LeetCode.month06.day16;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/16 14:57
 */
public class demo8 {
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return target;
                if (Math.abs(res - target) > Math.abs(sum - target)) res = sum;
                if (sum > target) {
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                } else {
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                }
            }
        }
        return res;
    }
}

