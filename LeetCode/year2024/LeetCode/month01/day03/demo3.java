package LeetCode.month01.day03;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/3 13:52
 */
public class demo3 {
    public int findTheLongestBalancedSubstring(String s) {
        int res = 0;
        int numZero = 0, numOne = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - '0';
            if (cur == 0 && numOne != 0) {
                res = Math.max(res, 2 * Math.min(numOne, numZero));
                numZero = 1;
                numOne = 0;
            } else if (cur == 1) {
                numOne++;
            } else {
                numZero++;
            }
        }
        return Math.max(res, 2 * Math.min(numOne, numZero));
    }
}

