package month10.day11;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/group-anagrams/?envType=list&envId=hliQiQFH
 * @date 2023/10/11 12:07
 */
public class demo2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            List<String> list = map.get(s);
            if (list == null) {
                list = new ArrayList<>();
                map.put(s, list);
            }
            list.add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> value : map.values()) {
            res.add(value);
        }
        return res;
    }
}

