package LeetCode.month06.day25;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/25 11:07
 */
public class demo7 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String s = s1 + s1;
        return s.contains(s2);
    }
}

