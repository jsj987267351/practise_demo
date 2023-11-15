package month11.day15;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/15 14:24
 */
public class demo1 {
    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return k * max + k * (k - 1) / 2;
    }
}

