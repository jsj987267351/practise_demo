package LeetCode.month06.day28;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/28 9:54
 */
public class demo4 {
    class StockPrice {
        int cur;
        Map<Integer, Integer> map;
        //        key:价格，value:出现次数
        TreeMap<Integer, Integer> treeMap;

        public StockPrice() {
            cur = -1;
            map = new HashMap<>();
            treeMap = new TreeMap<>();
        }

        public void update(int timestamp, int price) {
            if (map.containsKey(timestamp)){
                int oldPrice = map.get(timestamp);
                int count = treeMap.get(oldPrice);
                if (count == 1) {
                    treeMap.remove(oldPrice);
                } else {
                    treeMap.put(oldPrice, count - 1);
                }
            }
            map.put(timestamp, price);
            treeMap.put(price, treeMap.getOrDefault(price, 0) + 1);
            cur = Math.max(cur, timestamp);
        }

        public int current() {
            return map.get(cur);
        }

        public int maximum() {
            return treeMap.lastKey();
        }

        public int minimum() {
            return treeMap.firstKey();
        }
    }
}

