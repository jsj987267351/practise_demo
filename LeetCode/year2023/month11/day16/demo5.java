package month11.day16;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/16 12:37
 */
public class demo5 {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE, res = 0;
        Arrays.sort(nums);
        for (int one = 0; one < nums.length - 2; one++) {
            if (one > 0 && nums[one] == nums[one - 1]) {
                continue;
            }
            int two = one + 1, three = nums.length - 1;
            while (two < three) {
                int sum = nums[one] + nums[two] + nums[three];
                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    res = sum;
                }
                if (diff == 0) {
                    return res;
                }
                if (sum > target) {
                    while (two < three && nums[three] == nums[three - 1]) {
                        three--;
                    }
                    three--;
                }
                if (sum < target) {
                    while (two < three && nums[two] == nums[two + 1]) {
                        two++;
                    }
                    two++;
                }
            }
        }
        return res;
    }
}

