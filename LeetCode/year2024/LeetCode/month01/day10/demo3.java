package LeetCode.month01.day10;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/9 14:46
 */
public class demo3 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] ints1 = new int[26];
        int[] ints2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            ints1[word1.charAt(i) - 'a']++;
            ints2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ints1[i] != 0 && ints2[i] == 0 || ints1[i] == 0 && ints2[i] != 0) {
                return false;
            }
        }
        Arrays.sort(ints1);
        Arrays.sort(ints2);
        return Arrays.equals(ints1, ints2);
    }
}

