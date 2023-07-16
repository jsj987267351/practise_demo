package month07.day16;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 * https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/?envType=study-plan-v2&envId=coding-interviews
 * @date 2023/7/16 12:18
 */
public class demo1 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int num = nums[left] + nums[right];
            if (num > target) {
                right--;
            } else if (num < target) {
                left++;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return nums;
    }
}

