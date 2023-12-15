package month12.day15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/15 15:11
 */
public class demo3 {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            set.remove(word);
            if (help(word, set)) {
                return word;
            }

        }
        return "";
    }

    public boolean help(String word, Set<String> set) {
        int length = word.length();
        if (length == 0) return true;
        for (int i = 0; i < length; i++) {
            if (set.contains(word.substring(0, i + 1)) && help(word.substring(i + 1, length), set)) {
                return true;
            }
        }
        return false;
    }
}

