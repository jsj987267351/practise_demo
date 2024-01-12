package LeetCode.month01.day12;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/12 12:02
 */
public class demo1 {
    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String s : words1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        for (String s : words2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }
        int res = 0;
        for (String key : map1.keySet()) {
            if (map1.get(key) == 1 && map2.containsKey(key) && map2.get(key) == 1) {
                res++;
            }
        }
        return res;
    }
}

