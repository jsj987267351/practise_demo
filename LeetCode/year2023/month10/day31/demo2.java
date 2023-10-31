package month10.day31;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/31 11:28
 */
public class demo2 {
    public boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        if (ss.length != pattern.length()) return false;
        Map<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i)) && !map.containsKey(ss[i]) || !map.containsKey(pattern.charAt(i)) && map.containsKey(ss[i])) {
                return false;
            }
            if (!map.containsKey(pattern.charAt(i)) && !map.containsKey(ss[i])) {
                map.put(pattern.charAt(i), i);
                map.put(ss[i], i);
                continue;
            }
            if (!map.get(pattern.charAt(i)).equals(map.get(ss[i]))) {
                return false;
            }
            map.put(pattern.charAt(i), i);
            map.put(ss[i], i);
        }
        return true;
    }
}

