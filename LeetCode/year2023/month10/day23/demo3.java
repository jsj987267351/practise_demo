package month10.day23;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/23 12:56
 */
public class demo3 {
    public char dismantlingAction1(String arr) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = arr.toCharArray();
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }

        for (char aChar : chars) {
            if (map.get(aChar) == 1) {
                return aChar;
            }
        }
        return ' ';
    }

    public char dismantlingAction(String arr) {
        int[] ints = new int[26];
        for (char c : arr.toCharArray()) {
            ints[c - 'a']++;
        }

        for (char c : arr.toCharArray()) {
            if (ints[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }
}

