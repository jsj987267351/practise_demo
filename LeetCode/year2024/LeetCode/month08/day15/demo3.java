package LeetCode.month08.day15;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/15 10:12
 */
public class demo3 {
    public boolean canJump(int[] nums) {
        int Max = nums[0];
        for (int i = 0; i <= Max; i++) {
            Max = Math.max(Max, i + nums[i]);
            if (Max >= nums.length - 1) return true;
        }
        return false;
    }
}

