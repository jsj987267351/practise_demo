package LeetCode.month07.day12;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/12 10:52
 */
public class demo7 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (char c : word1.toCharArray()) {
            arr1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            arr2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr1[i] == 0 && arr2[i] != 0) {
                return false;
            } else if (arr1[i] != 0 && arr2[i] == 0) {
                return false;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}

