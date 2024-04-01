package LeetCode.month03.day18;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/18 12:59
 */
public class demo1 {
    class NumArray {
        int[] arr;

        public NumArray(int[] nums) {
            int length = nums.length;
            arr = new int[length + 1];
            for (int i = 0; i < length; i++) {
                arr[i + 1] = nums[i] + arr[i];
            }
        }

        public int sumRange(int left, int right) {
            return arr[right + 1] - arr[left];
        }
    }
}

