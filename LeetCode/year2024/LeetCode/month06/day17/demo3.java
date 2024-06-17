package LeetCode.month06.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/17 13:56
 */
public class demo3 {
    public void sortColors(int[] nums) {
        int redIndex = 0, blueIndex = nums.length - 1, index = 0;
        while (index <= blueIndex) {
            if (nums[index] == 0) {
                swap(nums, index, redIndex);
                redIndex++;
                index++;
            } else if (nums[index] == 2) {
                swap(nums, index, blueIndex);
                blueIndex--;
            } else {
                index++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

