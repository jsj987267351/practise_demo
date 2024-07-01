package LeetCode.month07.day01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/1 10:22
 */
public class demo8 {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        Arrays.sort(words, (a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            set.remove(word);
            if (isValid(set, word)) {
                return word;
            }
        }
        return "";
    }

    public boolean isValid(Set<String> set, String word) {
        if (word.isEmpty()) return true;
        for (int i = 0; i < word.length(); i++) {
            if (set.contains(word.substring(0, i + 1)) && isValid(set, word.substring(i + 1))) {
                return true;
            }
        }
        return false;
    }
}

