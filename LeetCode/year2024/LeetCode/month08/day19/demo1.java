package LeetCode.month08.day19;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/19 9:29
 */
public class demo1 {
    public int removeDuplicates(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[res]) {
                nums[++res] = nums[i];
            }
        }
        return res + 1;
    }
}

