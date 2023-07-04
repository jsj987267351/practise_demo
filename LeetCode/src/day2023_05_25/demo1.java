package day2023_05_25;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/group-anagrams
 * @date 2023/5/25 13:19
 */
public class demo1 {
    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> result = new ArrayList<>();
//        判断是否使用过，默认为false，使用过改为true
        boolean[] used = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (used[i]) continue;
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            used[i] = true;
            for (int j = i + 1; j < strs.length; j++) {
                if (used[j]) continue;
                if (help(strs[i], strs[j])) {
                    list.add(strs[j]);
                    used[j] = true;
                }
            }
            result.add(list);
        }
        return result;
    }


    //    判断两个字符串是否为 字母异位词
    public boolean help(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }
        int[] alpha = new int[26];
        for (int i = 0; i < a.length(); i++) {
            alpha[a.charAt(i) - 'a']++;
            alpha[b.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (alpha[i] != 0) return false;
        }

        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
//        对数组中每一个字符串进行排序，排序后的字符串作为key，未排序的加入value中
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
//            拿出key值对应的数组，如果不存在的话就创建一个新的，将value加入数组后重新加入map覆盖
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
//        转换这一步不会
        return new ArrayList<List<String>>(map.values());
    }


}

