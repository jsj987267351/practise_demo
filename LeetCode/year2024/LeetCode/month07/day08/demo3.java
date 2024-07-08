package LeetCode.month07.day08;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/8 11:30
 */
public class demo3 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int len = spells.length;
        int[] res = new int[len];
        Arrays.sort(potions);
        for (int i = 0; i < len; i++) {
            int cur = spells[i];
            int left = 0, right = potions.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (((long) cur * potions[mid]) >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                res[i] = potions.length - left;
            }
        }
        return res;
    }
}

