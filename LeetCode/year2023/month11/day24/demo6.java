package month11.day24;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/24 13:29
 */
public class demo6 {
    class RandomizedSet {
        Random random;
        List<Integer> list;
        Map<Integer, Integer> map;

        public RandomizedSet() {
//            list只有删除最后一个元素时时间复杂度是O（1）
            random = new Random();
            list = new ArrayList<>();
            map = new HashMap<>();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            int size = list.size();
            map.put(val, size);
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int index = map.get(val);
            int last = list.get(list.size() - 1);
            if (last != val) {
                map.put(last, index);
                list.set(index, last);
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

