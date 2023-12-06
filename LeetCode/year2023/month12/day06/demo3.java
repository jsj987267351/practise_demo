package month12.day06;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/6 13:27
 */
public class demo3 {
    public boolean isFlipedString(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String s = s1 + s1;
        return s.contains(s2);
    }
}

