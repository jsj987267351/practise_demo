package day28;

import java.util.HashMap;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * https://leetcode.cn/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * @date 2023/4/19 14:43
 */
public class demo2 {
    public char firstUniqChar1(String s) {
        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i) - 'a']++;
        }
        int temp = Integer.MAX_VALUE;
        int min = -1;
        for (int i = 0; i < 26; i++) {
            if (ints[i] == 1) {
                for (int j = 0; j < s.length(); j++) {
                    if ((char) (i + 'a') == s.charAt(j) && j < temp) {
                        min = i;
                        temp = j;
                        break;
                    }
                }
            }
        }
        if (min!= -1){
            return (char) (min + 'a');
        }
        return ' ';
    }

    public static char firstUniqChar2(String s) {
        boolean flag = true;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (i == j){
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if (flag){
                return s.charAt(i);
            }else {
                flag =true;
            }
        }
        return ' ';
    }

    public static char firstUniqChar(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();

        for (char ch :chars){
            map.put(ch,!map.containsKey(ch));
        }

        for (char ch : chars) {
            if (map.get(ch)) return ch;
        }
        return ' ';
    }

}

