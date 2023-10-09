package month10.day09;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/9 12:11
 */
public class demo4 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> maps = new HashMap<>();
        Map<Character, Character> mapt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            if (maps.containsKey(ss) && maps.get(ss) != tt || mapt.containsKey(tt) && mapt.get(tt) != ss) {
                return false;
            }
            maps.put(ss, tt);
            mapt.put(tt, ss);
        }
        return true;
    }
}

