package LeetCode.month06.day15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/15 14:24
 */
public class demo3 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) != t.charAt(i)) {
                return false;
            } else if (!map.containsKey(c) && set.contains(t.charAt(i))) {
                return false;
            }
            map.put(c, t.charAt(i));
            set.add(t.charAt(i));
        }
        return true;
    }
}

