package day2023_04_18;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * https://leetcode.cn/problems/check-permutation-lcci/
 * @date 2023/4/18 13:31
 */
public class demo2 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] ints = new int[26];
        int[] ints1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {

            ints[s1.charAt(i) - 'a']++;
            ints1[s2.charAt(i) - 'a']++;
        }
        return Arrays.equals(ints,ints1);
    }
}

