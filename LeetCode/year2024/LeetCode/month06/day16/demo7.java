package LeetCode.month06.day16;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/16 14:50
 */
public class demo7 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        int left = 0, right = 0;
        while (left < s.length() && right < t.length()) {
            char c = s.charAt(left);
            while (right < t.length() && c != t.charAt(right)) {
                right++;
            }
            if (right == t.length()) return false;
            right++;
            left++;
        }
        return left == s.length();
    }
}

