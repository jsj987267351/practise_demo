package month09.day21;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/21 13:36
 */
public class demo2 {
    class LRUCache {
        Map<Integer, Integer> map;
        int size;

        public LRUCache(int capacity) {
            map = new LinkedHashMap<>();
            size = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            } else {
                int res = map.get(key);
                map.remove(key);
                map.put(key, res);
                return res;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.remove(key);
            } else if (map.size() == size) {
                int last = map.keySet().iterator().next();
                map.remove(last);
            }
            map.put(key, value);
        }
    }
}

