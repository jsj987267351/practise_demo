package month11.day01;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/1 13:47
 */
public class demo6 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0){
            return;
        }
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;

        }
    }

}

