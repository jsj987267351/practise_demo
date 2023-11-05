package month11.day06;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/5 17:35
 */
public class demo5 {
    public List<Integer> findAnagrams(String s, String p) {
        int lens = s.length();
        int lenp = p.length();
        List<Integer> res = new ArrayList<>();
        if (lens < lenp) {
            return res;
        }
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < lenp; i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < lens) {
            char cur = s.charAt(right);
            right++;
            if (need.containsKey(cur)) {
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if (window.get(cur).equals(need.get(cur))) {
                    valid++;
                }
            }
            while (right - left >= lenp) {
                if (valid == need.size()) {
                    res.add(left);
                }
                char pre = s.charAt(left);
                left++;
                if (need.containsKey(pre)) {
                    if (window.get(pre).equals(need.get(pre))) {
                        valid--;
                    }
                    window.put(pre, window.get(pre) - 1);
                }
            }
        }
        return res;
    }


    public List<Integer> findAnagrams1(String s, String p) {
        int lens = s.length();
        int lenp = p.length();
        List<Integer> res = new ArrayList<>();
        if (lens < lenp) return res;
        int[] need = new int[26];
        int[] window = new int[26];
        for (int i = 0; i < lenp; i++) {
            need[p.charAt(i) - 'a']++;
            window[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(need, window)) {
            res.add(0);
        }
        for (int i = lenp; i < lens; i++) {
            window[s.charAt(i - lenp) - 'a']--;
            window[s.charAt(i) - 'a']++;
            if (Arrays.equals(need, window)) {
                res.add(i - lenp + 1);
            }
        }
        return res;
    }
}

