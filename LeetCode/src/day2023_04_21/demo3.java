package day2023_04_21;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * https://leetcode.cn/problems/longest-palindromic-substring/
 * @date 2023/4/21 14:39
 */
public class demo3 {
    public String longestPalindrome1(String s) {
        if (s.length() < 2) {
            return s;
        }
        int max = 1;
        int begin = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (j - i + 1 > max && huiwen(chars, i, j)) {
                    begin = i;
                    max = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + max);
    }

    public boolean huiwen(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public String longestPalindrome2(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }

        int max = 1;
        int begin = 0;

        char[] chars = s.toCharArray();
        boolean[][] booleans = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            booleans[i][i] = true;
        }

        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    booleans[i][j] = false;
                } else if (j - i < 3) {
                    booleans[i][j] = true;
                } else {
                    booleans[i][j] = booleans[i + 1][j - 1];
                }
                if (booleans[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + max);
    }


    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int[] result = new int[2];
        char[] chars = s.toCharArray();
        int maxlength = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            int[] self = centerSpread(chars, i, i);
            int[] jia1 = centerSpread(chars, i, i + 1);
            int[] max = self[1] > jia1[1] ? self : jia1;
            if (max[1] > maxlength){
                result = max;
                maxlength = result[1];
            }
        }
        return s.substring(result[0],result[0]+result[1]);
    }

    public int[] centerSpread(char[] chars, int left, int right) {
        int length = chars.length;
        while (left >= 0 && right < length) {
            if (chars[left] == chars[right]) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return new int[]{left + 1, right - left - 1};
    }
}

