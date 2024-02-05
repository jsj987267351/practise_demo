package LeetCode.month02.day05;

import java.util.ArrayDeque;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/5 14:13
 */
public class demo {
    public int maxResult(int[] nums, int k) {
//        灵神
        int len = nums.length;
//        dp[i]:表示到达下标i的最大得分
        int[] dp = new int[len];
        dp[0] = nums[0];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        for (int i = 1; i < len; i++) {
//            跳不到当前位置,这里可以不用while而使用if是因为每次走一格，也就是每次最多只会添加进去一个元素
//            如果当前元素不符合那么下一个元素就一定符合，因为每次都会判断
            if (queue.peekFirst() < i - k) {
                queue.pollFirst();
            }
//            队列头部就是能跳到当前位置的最大值
            dp[i] = dp[queue.peekFirst()] + nums[i];
            while (!queue.isEmpty() && dp[i] >= dp[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.add(i);
        }
        return dp[len - 1];
    }
}

