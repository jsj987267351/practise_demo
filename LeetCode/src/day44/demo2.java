package day44;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/5/16 16:05
 */
public class demo2 {
    class LRUCache {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            } else {
//                重新删除插入，保证有序
                Integer temp = map.get(key);
                map.remove(key);
                map.put(key, temp);
                return temp;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.remove(key);
            } else if (map.size() == capacity){
//               删除最后一个
                Integer last = map.keySet().iterator().next();
                map.remove(last);
            }
            map.put(key, value);
        }
    }
}

