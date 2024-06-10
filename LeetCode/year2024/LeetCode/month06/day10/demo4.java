package LeetCode.month06.day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/10 16:40
 */
public class demo4 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            right++;
            window.put(cur, window.getOrDefault(cur, 0) + 1);
            if (need.containsKey(cur)) {
                if (window.get(cur).equals(need.get(cur))) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }
                char curLeft = s.charAt(left++);
                if (need.containsKey(curLeft)) {
                    if (window.get(curLeft).equals(need.get(curLeft))) {
                        valid--;
                    }
                }
                window.put(curLeft, window.get(curLeft) - 1);
            }
        }
        return res;
    }
}

