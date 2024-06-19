package LeetCode.month06.day19;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/19 11:33
 */
public class demo8 {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }
        int res = Integer.MAX_VALUE;
        for (int front : fronts) {
            if (!set.contains(front)) {
                res = Math.min(res, front);
            }
        }
        for (int back : backs) {
            if (!set.contains(back)) {
                res = Math.min(res, back);
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

