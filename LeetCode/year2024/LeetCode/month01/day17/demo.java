package LeetCode.month01.day17;


import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/17 11:58
 */
public class demo {
    public int maximumNumberOfStringPairs(String[] words) {
        int res = 0;
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            if (set.contains(word)) {
                String copy = new StringBuilder(word).reverse().toString();
                set.remove(word);
                if (set.contains(copy)) {
                    res++;
                    set.remove(copy);
                }
            }
        }
        return res;
    }
}

