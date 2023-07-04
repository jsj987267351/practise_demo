package day2023_03_30;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。  请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * @date 2023/3/30 11:51
 * https://leetcode.cn/problems/move-zeroes/
 */
public class demo2 {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }
}

