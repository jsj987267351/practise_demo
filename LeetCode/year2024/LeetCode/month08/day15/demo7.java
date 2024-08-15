package LeetCode.month08.day15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/15 10:36
 */
public class demo7 {
    public int[][] fileCombination(int target) {
        List<int[]> res = new ArrayList<>();
        int left = 1, right = 1, sum = 0;
        while (left <= target / 2) {
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                int[] cur = new int[right - left];
                for (int i = left; i < right; i++) {
                    cur[i - left] = i;
                }
                res.add(cur);
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

