package month10.day10;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/10 13:59
 */
public class demo5 {
    public int pivotIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int LeftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] - LeftSum == LeftSum) {
                return i;
            }
            LeftSum += nums[i];
        }
        return -1;
    }
}

