package month10.day30;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/30 12:23
 */
public class demo4 {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        int max = 0, left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(chars[i])) {
                int leftIndex = map.get(chars[i]);
                left = Math.max(left, leftIndex + 1);
            }
            map.put(chars[i], i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}

