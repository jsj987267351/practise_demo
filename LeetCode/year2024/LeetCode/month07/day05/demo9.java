package LeetCode.month07.day05;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/5 10:42
 */
public class demo9 {
    public int[] shortestSeq(int[] big, int[] small) {
        Set<Integer> need = new HashSet<>();
        for (int j : small) {
            need.add(j);
        }
        Map<Integer, Integer> window = new HashMap<>();
        int left = 0, right = 0, start = -1, end = -1, len = Integer.MAX_VALUE;
        while (right < big.length) {
            int num = big[right++];
            if (need.contains(num)) {
                window.put(num, window.getOrDefault(num, 0) + 1);
            }
            while (window.size() == need.size()) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                    end = right - 1;
                }
                int removeNum = big[left++];
                if (need.contains(removeNum)) {
                    window.put(removeNum, window.get(removeNum) - 1);
                    if (window.get(removeNum) == 0) {
                        window.remove(removeNum);
                    }
                }
            }
        }
        if (start == -1 && end == -1) {
            return new int[]{};
        }
        return new int[]{start, end};
    }
}

