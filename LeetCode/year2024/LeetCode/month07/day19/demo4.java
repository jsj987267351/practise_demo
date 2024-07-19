package LeetCode.month07.day19;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/19 10:06
 */
public class demo4 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            int left = 0, right = 0;
            while (right < word.length()) {
                if (word.charAt(right) == separator) {
                    if (right > left) {
                        res.add(word.substring(left, right));
                    }
                    left = right + 1;
                } else if (right == word.length() - 1) {
                    res.add(word.substring(left));
                }
                right++;
            }
        }
        return res;
    }
}

