package month11.day16;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/16 12:15
 */
public class demo3 {
    public boolean isSubsequence(String s, String t) {
        int index0 = 0, index1 = 0;
        while (index0 < s.length() && index1 < t.length()) {
            if (t.charAt(index1) == s.charAt(index0)) {
                index0++;
            }
            index1++;
        }
        return index0 == s.length();
    }
}

