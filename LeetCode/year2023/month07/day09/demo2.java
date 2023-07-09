package month07.day09;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/7/9 19:07
 */
public class demo2 {
    public int threeSumClosest(int[] nums, int target) {
        int help = Integer.MAX_VALUE;

        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            int numOne = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int num = numOne + nums[left] + nums[right];
                if (Math.abs(help - target) > Math.abs(num - target)) {
                    help = num;
                }
                if (num == target) {
                    return target;
                }
                if (num > target) {
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
        return help;
    }
}

