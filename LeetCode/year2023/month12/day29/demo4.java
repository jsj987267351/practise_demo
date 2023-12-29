package month12.day29;

import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/29 13:51
 */
public class demo4 {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            maxHeap.offer(num);
        }
        long res = 0;
        while (k-- > 0) {
            int max = maxHeap.poll();
            res += max;
            maxHeap.offer((int) Math.ceil(max / 3.0));
        }
        return res;
    }
}

