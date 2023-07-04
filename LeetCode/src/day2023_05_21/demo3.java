package day2023_05_21;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/next-permutation/
 * @date 2023/5/21 15:15
 */
public class demo3 {
    public void nextPermutation(int[] nums) {
//        首先从后往前找到降序的缺口，并存储下标
//        然后重新从后往前遍历，找到第一个大于缺口的值，接着交换后将缺口后续改成升序即可
        if (nums.length == 1) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
//            找到缺口
            i--;
        }
        if (i>=0){
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}

