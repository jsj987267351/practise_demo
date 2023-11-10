package month11.day10;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/10 13:16
 */
public class demo1 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int poLength = potions.length;
        int length = spells.length;
        int[] res = new int[length];
        Arrays.sort(potions);
        for (int i = 0; i < length; i++) {
            int curSpell = spells[i];
            int left = 0, right = poLength - 1, min = -1;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                long curSum = (long) curSpell * potions[mid];
                if (curSum < success) {
                    left = mid + 1;
                } else {
                    min = mid;
                    right = mid - 1;
                }
            }
            if (min != -1) {
                res[i] = poLength - left;
            }
        }
        return res;
    }
}

