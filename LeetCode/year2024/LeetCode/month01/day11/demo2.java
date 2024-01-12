package LeetCode.month01.day11;

import java.util.ArrayDeque;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/11 14:29
 */
public class demo2 {
    private static final long MOD = (long) 1e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        long res = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i <= arr.length; i++) {
            int cur = i == arr.length ? -1 : arr[i];
            while (stack.size() > 1 && cur <= arr[stack.peek()]) {
                int curIndex = stack.pop();
                res += (long) arr[curIndex] * (curIndex - stack.peek()) * (i - curIndex);
            }
            stack.push(i);
        }
        return (int) (res % MOD);
    }
}

