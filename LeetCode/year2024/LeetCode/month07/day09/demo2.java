package LeetCode.month07.day09;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/9 9:34
 */
public class demo2 {
    public String[] findLongestSubarray(String[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, sum = 0, max = 0;
        map.put(0, -1);
        for (int i = 0; i < array.length; i++) {
            sum += array[i].charAt(0) >= 'A' ? 1 : -1;
            if (map.containsKey(sum)) {
                int firstIndex = map.get(sum);
                if (i - firstIndex > max) {
                    start = firstIndex + 1;
                    max = i - firstIndex;
                }
            } else {
                map.put(sum, i);
            }
        }
        String[] res = new String[max];
        for (int i = 0; i < max; i++) {
            res[i] = array[i + start];
        }
        return res;
    }
}

