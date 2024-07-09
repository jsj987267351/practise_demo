package LeetCode.month07.day09;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/9 10:30
 */
public class demo7 {
    public int minDeletion(int[] nums) {
        int len = nums.length, deleted = 0;
        for (int i = 0; i < len; i++) {
            if ((i - deleted) % 2 != 0 && nums[i] == nums[i - 1]) {
                deleted++;
            }
        }
        return (len - deleted) % 2 == 0 ? deleted : deleted + 1;
    }
}

