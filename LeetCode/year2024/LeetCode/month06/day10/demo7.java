package LeetCode.month06.day10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/10 17:07
 */
public class demo7 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, start = 0, end = Integer.MAX_VALUE, valid = 0;
        while (right < s.length()) {
            char curRight = s.charAt(right++);
            if (need.containsKey(curRight)) {
                window.put(curRight, window.getOrDefault(curRight, 0) + 1);
                if (window.get(curRight).equals(need.get(curRight))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < end - start) {
                    start = left;
                    end = right;
                }
                char curLeft = s.charAt(left++);
                if (need.containsKey(curLeft)) {
                    if (window.get(curLeft).equals(need.get(curLeft))) {
                        valid--;
                    }
                    window.put(curLeft, window.get(curLeft) - 1);
                }
            }
        }
        return end == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }
}

