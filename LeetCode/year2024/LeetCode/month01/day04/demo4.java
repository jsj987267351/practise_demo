package LeetCode.month01.day04;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/4 13:14
 */
public class demo4 {
    public int minDeletion1(int[] nums) {
        int deleted = 0, length = nums.length;
        for (int i = 0; i < length; i++) {
            if ((i - deleted) % 2 == 0 && i < length - 1 && nums[i + 1] == nums[i]) {
                deleted++;
            }
        }
        return (length - deleted) % 2 == 0 ? deleted : deleted + 1;
    }

    public int minDeletion(int[] nums) {
        int deleted = 0, length = nums.length;
        for (int i = 0; i < length; i++) {
            if ((i - deleted) % 2 != 0 && nums[i - 1] == nums[i]) {
                deleted++;
            }
        }
        return (length - deleted) % 2 == 0 ? deleted : deleted + 1;
    }
}

