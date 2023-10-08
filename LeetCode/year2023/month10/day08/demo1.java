package month10.day08;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/stock-price-fluctuation/description/?envType=daily-question&envId=2023-10-08
 * @date 2023/10/8 11:49
 */
public class demo1 {
    class StockPrice {
        Map<Integer, Integer> map;
        TreeMap<Integer, Integer> treeMap;
        int cur;

        public StockPrice() {
//            map用来存储每个时间点的最新价格,key为时间节点，value为对应价格
            map = new HashMap<>();
//            treemap会根据key升序排列，所以key为股票出现价格，value为当前价格出现次数
            treeMap = new TreeMap<>();
//            最新时间节点
            cur = -1;
        }

        public void update(int timestamp, int price) {
//          每次先更新时间节点，保证是最新时间节点
            cur = Math.max(cur, timestamp);
//            如果map集合存在当前时间节点的价格，代表为更新价格
            if (map.containsKey(timestamp)) {
//                首先拿到更新前的价格
                int oldPrice = map.get(timestamp);
//                拿到更新前的价格存在的次数
                int num = treeMap.get(oldPrice);
//                因为是更新，所以更新前的价格出线的次数要-1,所以如果这个价格如果只出现一次的话，那么就直接删除
                if (num == 1) {
                    treeMap.remove(oldPrice);
                } else {
//                    否则的话将当前价格出现次数减少一次，因为有可能别的时间点也出现过当前价格
                    treeMap.put(oldPrice, num - 1);
                }
            }
//            更新map与treemap，treemap新价格出现次数+1
            map.put(timestamp, price);
            treeMap.put(price, treeMap.getOrDefault(price, 0) + 1);
        }

        public int current() {
//            直接返回最新价格
            return map.get(cur);
        }

//        因为treemap是按照价格升序的，价格为key，所以直接返回头尾key即可
        public int maximum() {
            return treeMap.lastKey();
        }

        public int minimum() {
            return treeMap.firstKey();
        }
    }
}

