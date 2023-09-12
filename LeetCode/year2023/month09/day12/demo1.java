package month09.day12;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/group-anagrams-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/12 11:48
 */
public class demo1 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(s, newList);
            }
        }
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}

