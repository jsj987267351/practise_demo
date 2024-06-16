package LeetCode.month06.day16;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/16 14:14
 */
public class demo4 {
    public void nextPermutation(int[] nums) {
        int startIndex = nums.length - 2;
        while (startIndex >= 0 && nums[startIndex] >= nums[startIndex + 1]) {
            startIndex--;
        }
        if (startIndex == -1) {
            Arrays.sort(nums);
            return;
        }
        int rightIndex = nums.length - 1;
        while (rightIndex > startIndex && nums[rightIndex] <= nums[startIndex]) {
            rightIndex--;
        }
        swap(nums, startIndex, rightIndex);
        sort(nums, startIndex + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sort(int[] nums, int left) {
        int right = nums.length - 1;
        while (left <= right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}

