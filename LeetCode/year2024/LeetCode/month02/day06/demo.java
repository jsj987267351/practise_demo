package LeetCode.month02.day06;

import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/6 14:44
 */
public class demo {
    public int magicTower(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < 0) return -1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int res = 0;
        long hp = 1;
        for (int num : nums) {
            if (num < 0) {
                minHeap.offer(num);
            }
            hp += num;
            if (hp <= 0) {
                hp -= minHeap.poll();
                res++;
            }
        }
        return res;
    }
}

