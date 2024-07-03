package LeetCode.month07.day03;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/3 9:36
 */
public class demo2 {
    public boolean oneEditAway(String first, String second) {
        int longLength = first.length();
        int shortLength = second.length();
        char[] F = first.toCharArray();
        char[] S = second.toCharArray();
        if (longLength < shortLength) {
            return oneEditAway(second, first);
        }
        if (longLength - shortLength > 1) return false;
        int count = 0, longIndex = 0, shortIndex = 0;
        while (longIndex < longLength && shortIndex < shortLength && count < 2) {
            if (F[longIndex] == S[shortIndex]) {
                longIndex++;
                shortIndex++;
            } else {
                if (longLength == shortLength) {
                    longIndex++;
                    shortIndex++;
                } else {
                    longIndex++;
                }
                count++;
            }
        }
        return count < 2;
    }
}

