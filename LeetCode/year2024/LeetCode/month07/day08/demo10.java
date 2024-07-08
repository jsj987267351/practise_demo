package LeetCode.month07.day08;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/8 11:03
 */
public class demo10 {
    public int findTheLongestBalancedSubstring(String s) {
        char[] charArray = s.toCharArray();
        int res = 0, zeroCount = 0, oneCount = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '0' && oneCount != 0) {
                res = Math.max(res, Math.min(oneCount, zeroCount) * 2);
                oneCount = 0;
                zeroCount = 1;
            } else if (charArray[i] == '1') {
                oneCount++;
            } else {
                zeroCount++;
            }
        }
        return Math.max(res, Math.min(oneCount, zeroCount) * 2);
    }
}

