package month10.day13;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/next-permutation/description/?envType=list&envId=hliQiQFH
 * @date 2023/10/13 11:54
 */
public class demo2 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len < 2) return;
        int index = nums.length - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }
        if (index == -1) {
            Arrays.sort(nums);
            return;
        }
        int right = nums.length - 1;
        while (nums[right] <= nums[index]) {
            right--;
        }
        swap(nums, index, right);
        change(nums, index + 1);

    }

    private void change(int[] nums, int left) {
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}

