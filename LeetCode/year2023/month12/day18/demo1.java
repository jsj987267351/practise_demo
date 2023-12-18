package month12.day18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/18 14:12
 */
public class demo1 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
            list.add(new int[]{capital[i], profits[i]});
        }
        list.sort((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int index = 0;
        while (k-- > 0) {
            while (index < profits.length && list.get(index)[0] <= w) {
                maxHeap.offer(list.get(index++)[1]);
            }
            if (maxHeap.isEmpty()) {
                break;
            }
            w += maxHeap.poll();
        }
        return w;
    }
}

