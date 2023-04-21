package day30;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @date 2023/4/21 13:41
 */
public class demo2 {
    public int lengthOfLongestSubstring1(String s) {
        int max = 0;
        int sum = 0;
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(s.charAt(i))) {
                list.add(s.charAt(i));
                sum++;
            } else {
                if (max < sum) {
                    max = sum;
                }
                while (!list.get(0).equals(s.charAt(i))) {
                    list.remove(0);
                    sum--;
                }
                list.remove(0);
                list.add(s.charAt(i));
            }
        }
        return max > sum ? max : sum;
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

}

