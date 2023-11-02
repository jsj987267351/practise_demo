package month11.day02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/2 11:28
 */
public class demo1 {
    public  int countPoints(String rings) {
        int length = rings.length();
        if (length < 6) return 0;
        char[] chars = rings.toCharArray();
        int res = 0;
        Map<Integer, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < chars.length; i += 2) {
            char colour = chars[i];
            int index = chars[i + 1] - '0';
            Set<Character> set = map.get(index);
            if (set == null) {
                set = new HashSet<>();
            }
            set.add(colour);
            map.put(index,set);
        }

        for (int i = 0; i < 10; i++) {
            if (map.containsKey(i) && map.get(i).size() == 3) {
                res++;
            }
        }
        return res;
    }
}

