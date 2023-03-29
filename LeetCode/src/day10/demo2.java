package day10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * @date 2023/3/26 15:42
 */
public class demo2 {
    public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        int[] result = new int[nums.length + k];
        for (int i = 0; i < nums.length; i++) {
            result[i + k] = nums[i];
        }

        int i = k - 1;
        int j = result.length - 1;
        while (i >= 0) {
            result[i] = result[j];
            i--;
            j--;
        }
        for (int l = 0; l < nums.length; l++) {
            nums[l] = result[l];
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        int temp = 0;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

