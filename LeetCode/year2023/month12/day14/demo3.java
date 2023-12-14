package month12.day14;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/14 16:43
 */
public class demo3 {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0, j = 1; i < nums.length && j < nums.length; i += 2, j += 2) {
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

