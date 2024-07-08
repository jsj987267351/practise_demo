package LeetCode.month07.day08;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/8 10:07
 */
public class demo6 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int res = 0;
        for (int[] envelope : envelopes) {
            int index = binarySearch(envelopes, res - 1, envelope[1]);
            envelopes[index][1] = envelope[1];
            if (index == res) {
                res++;
            }
        }
        return res;
    }

    public int binarySearch(int[][] envelopes, int right, int target) {
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (envelopes[mid][1] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int binarySearch1(int[][] envelopes, int right, int target) {
        int left = -1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (envelopes[mid][1] >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}

