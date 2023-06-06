package day58;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * https://leetcode.cn/problems/first-missing-positive/?envType=study-plan-v2&envId=top-100-liked
 * @date 2023/6/6 15:37
 */
public class demo3 {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;

//        首先将在1到length 的值放在对应下标-1的位置上  例如1应该放在0上
        for (int i = 0; i < length;i++) {
//            nums[i]为当前下标的值  nums[nums[i]-1]为当前下标应该存放的索引的值  其中nums[i]-1为应该存放的索引
            while (nums[i] >= 1 && nums[i] <= length && nums[i]!=nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            }
        }
//        然后遍历数组，不匹配的即为缺少的值
        for (int i = 0; i < length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
//        如果都匹配，说明缺少的是长度值+1
        return length + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

