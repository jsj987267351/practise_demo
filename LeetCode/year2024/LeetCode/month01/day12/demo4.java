package LeetCode.month01.day12;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/11 15:07
 */
public class demo4 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] res = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            int[] cur = trips[i];
            int peopleNum = cur[0];
            int start = cur[1];
            int end = cur[2];
            res[start] -= peopleNum;
            res[end] += peopleNum;
        }
        for (int i = 0; i < 1001; i++) {
            capacity += res[i];
            if (capacity < 0) return false;
        }
        return true;
    }

    public boolean carPooling1(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < trips.length; i++) {
            int[] cur = trips[i];
            int peopleNum = cur[0];
            int start = cur[1];
            while (!minHeap.isEmpty() && minHeap.peek()[2] <= start) {
                int[] down = minHeap.poll();
                capacity += down[0];
            }
            minHeap.offer(cur);
            capacity -= peopleNum;
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }
}

