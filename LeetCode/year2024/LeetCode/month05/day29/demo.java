package LeetCode.month05.day29;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/29 14:24
 */
public class demo {
    public int maximumLength(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String cur = s.substring(i, j + 1);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
        }
        int res = -1;
        for (String key : map.keySet()) {
            if (map.get(key) > 2 && isValid(key)) {
                res = Math.max(res, key.length());
            }
        }
        return res;
    }

    public boolean isValid(String s) {
        if (s.length() == 1) return true;
        char a = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (a != s.charAt(i)) return false;
        }

        return true;
    }


}

