package LeetCode.month01.day08;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/8 11:51
 */
public class demo1 {
    public int numberOfBoomerangs(int[][] points) {
        int length = points.length;
        int res = 0;
        for (int i = 0; i < length; i++) {
            int[] one = points[i];
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < length; j++) {
                if (i == j) continue;
                int[] two = points[j];
                int x = one[0] - two[0];
                int y = one[1] - two[1];
                int dis = x * x + y * y;
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            for (int key : map.keySet()) {
                int value = map.get(key);
                if (value > 1) {
                    res += value * (value - 1);
                }
            }
        }
        return res;
    }
}

