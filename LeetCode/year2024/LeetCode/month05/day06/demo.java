package LeetCode.month05.day06;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/5/6 11:33
 */
public class demo {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        if (k == 0) {
            return new int[len];
        }
        int[] dp = new int[len];
        if (k > 0) {
            for (int i = 0; i < len; i++) {
                int temp = 0;
                for (int j = 1; j <= k; j++) {
                    temp += code[(i + j) % len];
                }
                dp[i] = temp;
            }
        } else {
            k = -k;
            for (int i = 0; i < len; i++) {
                int temp = 0;
                for (int j = 1; j <= k; j++) {
                    temp += code[((i - j) + len) % len];
                }
                dp[i] = temp;
            }
        }
        return dp;
    }
}

