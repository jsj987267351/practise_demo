package month11.day07;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/count-the-number-of-vowel-strings-in-range/description/?envType=daily-question&envId=2023-11-07
 * @date 2023/11/7 11:52
 */
public class demo1 {
    private static final String s = "aeiou";

    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (s.indexOf(word.charAt(0)) != -1 && s.indexOf(word.charAt(word.length() - 1)) != -1) {
                res++;
            }
        }
        return res;
    }

    public int vowelStrings1(String[] words, int left, int right) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (set.contains(word.charAt(0)) && set.contains(word.charAt(word.length() - 1))) {
                res++;
            }
        }
        return res;
    }
}

