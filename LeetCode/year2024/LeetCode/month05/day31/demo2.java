package LeetCode.month05.day31;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/31 11:33
 */
public class demo2 {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        int[] first = new int[length];
        first[0] = nums[0];
        first[1] = Math.max(nums[0], nums[1]);
        int[] second = new int[length];
        second[1] = nums[1];
        second[2] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < length - 1; i++) {
            first[i] = Math.max(nums[i] + first[i - 2], first[i - 1]);
        }
        for (int i = 3; i < length; i++) {
            second[i] = Math.max(nums[i] + second[i - 2], second[i - 1]);
        }
        return Math.max(first[length - 2], second[length - 1]);
    }

}

