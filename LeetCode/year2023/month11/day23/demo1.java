package month11.day23;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/23 12:08
 */
public class demo1 {
    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        int left = 0, right = 0;
        int length = text.length();
        StringBuilder res = new StringBuilder();
        while (left < length) {
            if (text.charAt(left) == '&') {
                right = left + 1;
                while (right < length && right - left < 6 && text.charAt(right) != ';') {
                    right++;
                }
                String sub = text.substring(left, Math.min(right + 1, length));
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

