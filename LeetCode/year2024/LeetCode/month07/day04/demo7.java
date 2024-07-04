package LeetCode.month07.day04;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/4 10:28
 */
public class demo7 {
    public List<String> getValidT9Words(String num, String[] words) {
        char[] chars = "22233344455566677778889999".toCharArray();
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (word.length() != num.length()) continue;
            int index = 0;
            for (; index < word.length(); index++) {
                int id = word.charAt(index) - 'a';
                if (chars[id] != num.charAt(index)) {
                    break;
                }
            }
            if (index == word.length()) {
                res.add(word);
            }
        }
        return res;
    }
}

