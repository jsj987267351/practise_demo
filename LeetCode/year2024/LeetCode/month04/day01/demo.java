package LeetCode.month04.day01;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/4/1 11:38
 */
public class demo {
    public String finalString(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'i') {
                res = res.reverse();
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}

