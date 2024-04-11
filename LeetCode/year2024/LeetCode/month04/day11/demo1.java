package LeetCode.month04.day11;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/11 11:45
 */
public class demo1 {
    public int maximumCount(int[] nums) {
        int left = Bin(nums, 0);
        int right = nums.length - Bin(nums, 1);
        return Math.max(left, right);
    }

    //    二分查找返回数组中第一个大于等于target的数字下标
    public int Bin(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int maximumCount1(int[] nums) {
        int countZ = 0, countF = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                countF++;
            } else if (nums[i] > 0) {
                countZ++;
            }
        }
        return Math.max(countF, countZ);
    }
}

