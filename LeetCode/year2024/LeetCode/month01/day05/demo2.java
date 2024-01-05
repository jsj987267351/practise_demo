package LeetCode.month01.day05;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/5 12:40
 */
public class demo2 {
    final long Mod = (long) 1e9 + 7;

    public int sumDistance(int[] nums, String s, int d) {
        int length = nums.length;
        long[] a = new long[length];
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'R') {
                a[i] = (long) nums[i] + d;
            } else {
                a[i] = (long) nums[i] - d;
            }
        }
        Arrays.sort(a);
        long res = 0, preSum = 0;
        for (int i = 0; i < length; i++) {
            res = (res + i * a[i] - preSum) % Mod;
            preSum += a[i];
        }
        return (int) res;
    }
}

