package LeetCode.month01.day05;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/5 13:19
 */
public class demo4 {
    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        StringBuilder res = new StringBuilder();
        int left = 0, right = 0, length = text.length();
        while (left < length) {
            if (text.charAt(left) == '&') {
                right = left + 1;
                while (right < length && text.charAt(right) != ';' && right - left < 6) {
                    right++;
                }
                String sub = text.substring(left, Math.min(length, right + 1));
                if (map.containsKey(sub)) {
                    res.append(map.get(sub));
                    left = right + 1;
                    continue;
                }
            }
            res.append(text.charAt(left++));
        }
        return res.toString();
    }
}

