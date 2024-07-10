package LeetCode.month07.day10;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/10 10:23
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
        int left = 0, right = 0;
        while (left < text.length()) {
            if (text.charAt(left) == '&') {
                right = left +1;
                while (right < text.length() && text.charAt(right) != ';' && right - left < 6) {
                    right++;
                }
                String sub = text.substring(left, Math.min(right + 1, text.length()));
                if (map.containsKey(sub)) {
                    res.append(map.get(sub));
                    left = right+1;
                    continue;
                }
            }
            res.append(text.charAt(left++));
        }
        return res.toString();
    }
}

