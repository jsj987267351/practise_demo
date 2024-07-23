package LeetCode.month07.day23;

import java.util.ArrayDeque;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/23 9:25
 */
public class demo1 {
    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        for (int i = 1; i < len; i++) {
            if (deque.getFirst() < i - k) {
                deque.removeFirst();
            }
            dp[i] = dp[deque.getFirst()] + nums[i];
            while (!deque.isEmpty() && dp[i] > dp[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        return dp[len - 1];
    }
}

