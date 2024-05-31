package LeetCode.month05.day31;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/31 13:14
 */
public class demo6 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }else if (set.contains(t.charAt(i))){
                return false;
            }
            map.put(s.charAt(i), t.charAt(i));
            set.add(t.charAt(i));
        }
        return true;
    }
}

