package month12.day02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/2 13:34
 */
public class demo2 {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                set.remove(chars[i]);
            } else {
                set.add(chars[i]);
            }
        }
        return set.size() < 2;
    }

    public boolean canPermutePalindrome1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int num = 0;
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        for (int value : map.values()) {
            if (value % 2 != 0) {
                num++;
            }
            if (num > 1) {
                return false;
            }
        }
        return true;
    }
}

