package LeetCode.month01.day08;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/7 14:27
 */
public class demo1 {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int res = 0, pre = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            pre += satisfaction[i];
            if (pre <= 0) break;
            res += pre;
        }
        return res;
    }
}

