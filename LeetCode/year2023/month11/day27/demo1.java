package month11.day27;

import java.util.ArrayDeque;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/27 12:35
 */
public class demo1 {
    private static final long MOD = (long) 1e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        long res = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int right = 0; right <= arr.length; right++) {
            int cur = right == arr.length ? -1 : arr[right];
            while (stack.size() > 1 && arr[stack.peek()] >= cur) {
                int curIndex = stack.pop();
                res += (long) arr[curIndex] * (curIndex - stack.peek()) * (right - curIndex);
            }
            stack.push(right);
        }
        return (int) (res % MOD);
    }
}

