package day2023_05_31;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/isomorphic-strings
 * @date 2023/5/31 14:00
 */
public class demo1 {
    public boolean isIsomorphic1(String s, String t) {
//        思路：两个数组都比较，分别建立map集合，用来记录各自字母上一次出现的位置，发现重复出现就找另一个字符串同位置是否出现重复，没出现就返回false。
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) != null) {
                Integer index = map.get(chars[i]);
                if (chart[i] != chart[index]) {
                    return false;
                }
            } else if (map1.get(chart[i]) != null) {
                return false;
            }
            map.put(chars[i], i);
            map1.put(chart[i], i);
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
//      实现双向映射,一一映射，
        Map<Character, Character> maps = new HashMap<>(), mapt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i), ct = t.charAt(i);
            if (maps.containsKey(cs) && maps.get(cs) != ct ||
                mapt.containsKey(ct) && mapt.get(ct) != cs) {
                return false;
            }
            maps.put(cs, ct);
            mapt.put(ct, cs);
        }
        return true;
    }
}

