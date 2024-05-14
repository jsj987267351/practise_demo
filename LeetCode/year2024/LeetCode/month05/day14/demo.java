package LeetCode.month05.day14;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/14 13:23
 */
public class demo {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        int res = 0;
        for (int value : map.values()) {
            if (value == 1) return -1;
            while (value > 4) {
                res++;
                value -= 3;
            }
            res += value / 2;
        }
        return res;
    }
}

