package LeetCode.month07.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/2 11:03
 */
public class demo11 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            list.add(new int[]{profits[i], capital[i]});
        }
        list.sort((a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int index = 0;
        while (k-- > 0) {
            while (index < profits.length && w >= list.get(index)[1]) {
                maxHeap.offer(list.get(index++)[0]);
            }
            if (maxHeap.isEmpty()) break;
            w += maxHeap.poll();
        }
        return w;
    }
}

