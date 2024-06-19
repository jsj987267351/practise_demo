package LeetCode.month06.day19;

import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/19 11:27
 */
public class demo7 {
    public int halveArray(int[] nums) {
        int res = 0;
        PriorityQueue<Double> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        double sum = 0;
        for (int num : nums) {
            sum += num;
            maxHeap.add((double) num);
        }
        double target = sum / 2;
        while (sum > target) {
            double max = maxHeap.poll();
            max /= 2.0;
            res++;
            sum -= max;
            maxHeap.add(max);
        }
        return res;
    }
}

