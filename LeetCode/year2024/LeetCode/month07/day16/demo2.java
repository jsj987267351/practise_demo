package LeetCode.month07.day16;

import java.util.ArrayDeque;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/16 9:38
 */
public class demo2 {
    private static final long MOD = (long) 1e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        long res = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.push(-1);
        for (int right = 0; right <= arr.length; right++) {
            int cur = right == arr.length ? -1 : arr[right];
            while (deque.size() > 1 && cur <= arr[deque.peek()]) {
                int middle = deque.pop();
                res += (long) arr[middle] * (right - middle) * (middle - deque.peek());
            }
            deque.push(right);
        }
        return (int) (res % MOD);
    }
}

