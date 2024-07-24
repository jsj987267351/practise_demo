package LeetCode.month07.day24;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/24 9:25
 */
public class demo1 {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < moveFrom.length; i++) {
            int move = moveFrom[i];
            int to = moveTo[i];
            int count = map.get(move);
            map.remove(move);
            map.put(to, map.getOrDefault(to, 0) + count);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer i : map.keySet()) {
            list.add(i);
        }
        Collections.sort(list);
        return list;
    }
}

