package LeetCode.month01.day03;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/3 13:57
 */
public class demo4 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int len = spells.length;
        int[] res = new int[len];
        int length = potions.length;
        Arrays.sort(potions);
        for (int i = 0; i < len; i++) {
            int cur = spells[i];
            int left = 0, right = length - 1;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                long sum = (long) potions[mid] * cur;
                if (sum < success) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            res[i] = length - left;
        }
        return res;
    }
}

