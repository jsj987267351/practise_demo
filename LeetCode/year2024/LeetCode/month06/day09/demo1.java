package LeetCode.month06.day09;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/9 17:15
 */
public class demo1 {
    public boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        if (pattern.length() != ss.length) return false;
        Map<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char curChar = pattern.charAt(i);
            String curString = ss[i];
            if (map.containsKey(curString) && !map.containsKey(curChar) || map.containsKey(curChar) && !map.containsKey(curString)) {
                return false;
            }
            if (!map.containsKey(curChar) && !map.containsKey(curString)) {
                map.put(curChar, i);
                map.put(curString, i);
                continue;
            }
            if (!map.get(curString).equals(map.get(curChar))) {
                return false;
            }
            map.put(curChar, i);
            map.put(curString, i);
        }
        return true;
    }
}

