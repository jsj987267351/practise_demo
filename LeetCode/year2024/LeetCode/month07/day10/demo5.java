package LeetCode.month07.day10;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/10 10:36
 */
public class demo5 {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int res = 0,preSum = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            preSum+=satisfaction[i];
            if (preSum <0) break;
            res+=preSum;
        }
        return res;
    }
}

