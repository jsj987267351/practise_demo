package LeetCode.month06.day28;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/28 10:15
 */
public class demo5 {
    class RandomizedSet {
        Map<Integer, Integer> map;
        List<Integer> list;
        Random random;

        public RandomizedSet() {
            random = new Random();
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            int index = list.size();
            list.add(val);
            map.put(val, index);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int last = list.get(list.size() - 1);
            if (last != val) {
                int index = map.get(val);
                list.set(index, last);
                map.put(last, index);
            }
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}

