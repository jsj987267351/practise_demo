package month12.day28;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/28 12:43
 */
public class demo1 {
    public int[] shortestSeq(int[] big, int[] small) {
        Set<Integer> need = new HashSet<>();
        for (int i : small) {
            need.add(i);
        }
        Map<Integer, Integer> window = new HashMap<>();
        int left = 0, right = 0, start = 0, end = 0, len = Integer.MAX_VALUE;
        while (right < big.length) {
            int rightValue = big[right];
            right++;
            if (need.contains(rightValue)) {
                window.put(rightValue, window.getOrDefault(rightValue, 0) + 1);
            }
            while (window.size() == need.size()) {
                if (right - left < len) {
                    start = left;
                    end = right -1;
                    len = right - left;
                }
                int leftValue = big[left];
                left++;
                if (need.contains(leftValue)) {
                    if (window.get(leftValue) == 1) {
                        window.remove(leftValue);
                    } else {
                        window.put(leftValue, window.get(leftValue) - 1);
                    }
                }
            }
        }
        if (start == 0 && end == 0) return new int[]{};
        return new int[]{start, end};
    }
}

