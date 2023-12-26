package month12.day26;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/26 12:58
 */
public class demo3 {
    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public int[] smallestK1(int[] arr, int k) {
        if (k == 0) {
            return new int[]{};
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : arr) {
            if (maxHeap.size() < k) {
                maxHeap.offer(num);
            } else if (num < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(num);
            }
        }
        int[] res = new int[maxHeap.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = maxHeap.poll();
        }
        return res;
    }
}

