package LeetCode.month05.day02;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/2 15:16
 */
public class demo {
    public long totalCost(int[] costs, int k, int candidates) {
        int len = costs.length;
        long res = 0;
        if (candidates * 2  + k > len) {
//            说明覆盖了整个数组，每个都可以直接取到。所以直接返回最小的即可
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                res += costs[i];
            }
            return res;
        }
//        否则维护两个小根堆，一个维护前candidates个，一个维护后candidates个
        PriorityQueue<Integer> pre = new PriorityQueue<>();
        PriorityQueue<Integer> aft = new PriorityQueue<>();
//        先将前candidates个和后candidates个放进去
        for (int i = 0; i < candidates; i++) {
            pre.add(costs[i]);
            aft.add(costs[len - i - 1]);
        }
//        双指针维护前后半段的边界
        int left = candidates, right = len - candidates - 1;
        while (k-- > 0) {
            if (pre.peek() <= aft.peek()) {
                res += pre.poll();
                pre.offer(costs[left++]);
            } else {
                res += aft.poll();
                aft.offer(costs[right--]);
            }
        }
        return res;
    }
}

