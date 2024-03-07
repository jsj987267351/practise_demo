package LeetCode.month03.day07;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/7 12:05
 */
public class demo {
    public int[] divisibilityArray(String word, int m) {
        int len = word.length();
        int[] res = new int[len];
        long sum = 0;
        for (int i = 0; i < len; i++) {
            sum = (sum * 10 + word.charAt(i) - '0') % m;
            if (sum == 0) {
                res[i] = 1;
            }
        }
        return res;
    }
}

