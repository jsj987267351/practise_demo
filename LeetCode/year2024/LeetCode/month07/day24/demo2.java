package LeetCode.month07.day24;

import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/24 9:36
 */
public class demo2 {
    public int magicTower(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < 0) {
            return -1;
        }
        long hp = 1;
        int res = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (num < 0) {
                minHeap.offer(num);
            }
            hp += num;
            if (hp <= 0) {
                res++;
                int min = minHeap.poll();
                hp -= min;
            }
        }
        return res;
    }
}

