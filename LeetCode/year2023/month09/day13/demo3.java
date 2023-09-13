package month09.day13;

import java.util.Arrays;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/peaks-and-valleys-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/13 13:20
 */
public class demo3 {
    public void wiggleSort1(int[] nums) {
        if (nums.length < 2) {
            return;
        }
//      直接对原数组进行复制后排序，排序后首尾挨个添加就是峰谷
        int[] copy = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(copy);
        int left = 0, right = nums.length - 1;
        int index = 0;
        while (index < nums.length) {
            nums[index++] = copy[right--];
            if (index < nums.length) {
                nums[index++] = copy[left++];
            }
        }
    }

    public void wiggleSort(int[] nums) {
//        排序后从头两两交换即可
        Arrays.sort(nums);
        for (int one = 0, two = 1; one < nums.length && two < nums.length; one += 2, two += 2) {
            swap(nums, one, two);
        }
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

