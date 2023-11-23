package month11.day23;

import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/23 13:05
 */
public class demo5 {
    public int halveArray(int[] nums) {
        double sum = 0;
        int res = 0;
        PriorityQueue<Double> heap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        for (int num : nums) {
            sum += num;
            heap.add(num * 1.0);
        }
        double target = sum / 2.0;
        while (true){
            double max = heap.poll();
            double num = max / 2.0;
            sum-=num;
            res++;
            heap.add(num);
            if (sum <= target){
                return res;
            }
        }
    }
}

