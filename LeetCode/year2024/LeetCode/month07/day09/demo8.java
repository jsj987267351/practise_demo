package LeetCode.month07.day09;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/9 10:36
 */
public class demo8 {
    public int sumDistance(int[] nums, String s, int d) {
        long Mod = (long) 1e9 + 7;
        long[] a = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (s.charAt(i) == 'R') {
                a[i] =(long) nums[i] + d;
            } else {
                a[i] =(long) nums[i] - d;
            }
        }
        Arrays.sort(a);
        long res = 0, preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            res = (res + i * a[i] - preSum) % Mod;
            preSum += a[i];
        }
        return (int) res;
    }
}

