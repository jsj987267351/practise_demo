package LeetCode.month06.day24;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/24 11:27
 */
public class demo7 {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        for (int value : map.values()) {
            if (value % 2 != 0) {
                count++;
            }
            if (count > 1) return false;
        }
        return true;
    }
}

