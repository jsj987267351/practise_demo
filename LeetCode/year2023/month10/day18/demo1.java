package month10.day18;

import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/maximal-score-after-applying-k-operations/description/?envType=daily-question&envId=2023-10-18
 * @date 2023/10/18 12:05
 */
public class demo1 {
    public long maxKelements(int[] nums, int k) {
        int len = nums.length;
        long res = 0;
        PriorityQueue<Integer> MaxHeap = new PriorityQueue<>(len, (a, b) -> b - a);
        for (int num : nums) {
            MaxHeap.add(num);
        }
        while (k > 0) {
            int poll = MaxHeap.poll();
            res += poll;
            MaxHeap.add((int) Math.ceil(poll / 3.0));
            k--;
        }
        return res;
    }
}

