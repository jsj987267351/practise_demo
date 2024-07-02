package LeetCode.month07.day02;

import java.security.Key;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/2 9:46
 */
public class demo3 {
    public int countSubstrings1(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();
        boolean[][] isHui = new boolean[len][len];
        int res = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (charArray[i] == charArray[j] && (j - i < 3 || isHui[i + 1][j - 1])) {
                    res++;
                    isHui[i][j] = true;
                }
            }
        }
        return res;
    }

    public int countSubstrings(String s) {
        char[] charArray = s.toCharArray();
        int len = s.length();
        int res = 0;
        for (int center = 0; center < 2 * len - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < len && charArray[left] == charArray[right]) {
                left--;
                right++;
                res++;
            }
        }
        return res;
    }
}

