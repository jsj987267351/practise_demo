package LeetCode.month05.day31;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/31 13:55
 */
public class demo12 {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] != nums[i + 1]) {
                count++;
            }
            if (count == 3) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}

