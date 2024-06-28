package LeetCode.month06.day28;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/28 10:32
 */
public class demo6 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String temp = str;
            char[] charArray = temp.toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            List<String> list = map.get(s);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(s, list);
        }
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        return res;
    }
}

