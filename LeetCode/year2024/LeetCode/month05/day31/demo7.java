package LeetCode.month05.day31;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/31 13:20
 */
public class demo7 {
    public int pivotIndex(int[] nums) {
        if (nums.length == 1) return 0;
        int sum = 0,preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (preSum == sum - nums[i] - preSum){
                return i;
            }
            preSum+=nums[i];
        }
        return -1;
    }
}

