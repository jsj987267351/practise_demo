package LeetCode.month06.day16;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/16 14:00
 */
public class demo2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int num : map.keySet()) {
            if (minHeap.size() < k) {
                minHeap.add(new int[]{num, map.get(num)});
            } else if (map.get(num) > minHeap.peek()[1]) {
                minHeap.poll();
                minHeap.add(new int[]{num, map.get(num)});
            }
        }
        int[] res = new int[minHeap.size()];
        int index = 0;
        while (!minHeap.isEmpty()) {
            res[index++] = minHeap.poll()[0];
        }
        return res;
    }
}

