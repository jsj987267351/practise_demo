package month11.day06;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/6 12:46
 */
public class demo3 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, valid = 0, len = Integer.MAX_VALUE, start = 0, end = 0;
        while (right < s.length()) {
            char last = s.charAt(right);
            right++;
            if (need.containsKey(last)) {
                window.put(last, window.getOrDefault(last, 0) + 1);
                if (window.get(last).equals(need.get(last))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    end = right;
                    len = right - left;
                }
                char first = s.charAt(left);
                left++;
                if (need.containsKey(first)) {
                    if (window.get(first).equals(need.get(first))) {
                        valid--;
                    }
                    window.put(first, window.get(first) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }


    public String minWindow1(String s, String t) {
        String res = "";
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            char last = s.charAt(right);
            right++;
            if (need.containsKey(last)) {
                window.put(last, window.getOrDefault(last, 0) + 1);
                if (window.get(last).equals(need.get(last))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (res.equals("") || res.length() > right - left) {
                    res = s.substring(left, right);
                }
                char first = s.charAt(left);
                left++;
                if (need.containsKey(first)) {
                    window.put(first, window.get(first) - 1);
                    if (window.get(first) < need.get(first)) {
                        valid--;
                    }
                }
            }
        }
        return res;
    }
}

