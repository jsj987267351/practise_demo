package month12.day23;

import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/23 12:29
 */
public class demo {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int pile : piles) {
            maxHeap.offer(pile);
        }
//        while (k-- > 0) {
//            int max = maxHeap.poll();
//            max -= max/2;
//            maxHeap.offer(max);
//        }
        for (int i = 0; i < k; i++) {
            int pile = maxHeap.poll();
            pile -= pile / 2;
            maxHeap.offer(pile);
        }
        int res = 0;
        while (!maxHeap.isEmpty()) {
            res += maxHeap.poll();
        }
        return res;
    }
}

