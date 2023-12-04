package month12.day04;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/4 13:41
 */
public class demo5 {
    public boolean oneEditAway(String first, String second) {
        int longLength = first.length();
        int shortLength = second.length();
        if (Math.abs(longLength - shortLength) > 1) {
            return false;
        }
        if (longLength < shortLength) {
            return oneEditAway(second, first);
        }
        int res = 0, longIndex = 0, shortIndex = 0;
        while (longIndex < longLength && shortIndex < shortLength && res < 2) {
            if (first.charAt(longIndex) == second.charAt(shortIndex)) {
                longIndex++;
                shortIndex++;
            } else {
                if (longLength == shortLength) {
                    longIndex++;
                    shortIndex++;
                } else {
                    longIndex++;
                }
                res++;
            }
        }
        return res < 2;
    }
}

