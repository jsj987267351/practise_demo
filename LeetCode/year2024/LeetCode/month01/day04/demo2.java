package LeetCode.month01.day04;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/4 12:49
 */
public class demo2 {
    class StockPrice {
        Map<Integer, Integer> map;
        TreeMap<Integer, Integer> treeMap;
        int cur;

        public StockPrice() {
            map = new HashMap<>();
            treeMap = new TreeMap<>();
            cur = 0;
        }

        public void update(int timestamp, int price) {
            cur = Math.max(timestamp, cur);
            if (map.containsKey(timestamp)) {
                int oldPrice = map.get(timestamp);
                int num = treeMap.get(oldPrice);
                if (num == 1) {
                    treeMap.remove(oldPrice);
                } else {
                    treeMap.put(oldPrice, num - 1);
                }
            }
            map.put(timestamp, price);
            treeMap.put(price, treeMap.getOrDefault(price, 0) + 1);
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

