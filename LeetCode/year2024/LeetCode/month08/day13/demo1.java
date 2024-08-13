package LeetCode.month08.day13;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/13 9:25
 */
public class demo1 {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) return false;
        }
        return true;
    }
}

