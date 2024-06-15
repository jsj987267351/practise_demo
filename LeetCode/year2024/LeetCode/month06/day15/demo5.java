package LeetCode.month06.day15;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/15 14:37
 */
public class demo5 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String temp = str;
            char[] charArray = temp.toCharArray();
            Arrays.sort(charArray);
            temp = String.valueOf(charArray);
            if (!map.containsKey(temp)) {
                map.put(temp, new ArrayList<>());
            }
            map.get(temp).add(str);
        }
        for (String s : map.keySet()) {
            result.add(map.get(s));
        }
        return result;
    }
}

