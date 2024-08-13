package LeetCode.month08.day13;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/13 9:41
 */
public class demo3 {
    public long totalCost(int[] costs, int k, int candidates) {
        long res = 0;
        if (candidates * 2 + k > costs.length) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                res += costs[i];
            }
            return res;
        }
        PriorityQueue<Integer> pre = new PriorityQueue<>();
        PriorityQueue<Integer> aft = new PriorityQueue<>();
        for (int i = 0; i < candidates; i++) {
            pre.add(costs[i]);
            aft.add(costs[costs.length - i - 1]);
        }
        int left = candidates, right = costs.length - candidates - 1;
        while (k-- > 0) {
            if (pre.peek() <= aft.peek()){
                res+=pre.poll();
                pre.add(costs[left++]);
            }else {
                res+=aft.poll();
                aft.add(costs[right--]);
            }
        }
        return res;
    }
}

