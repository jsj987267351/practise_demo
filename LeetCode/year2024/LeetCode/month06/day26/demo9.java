package LeetCode.month06.day26;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/26 10:48
 */
public class demo9 {
    public int crackNumber(int ciphertext) {
        if (ciphertext < 10) return 1;
        char[] charArray = String.valueOf(ciphertext).toCharArray();
        int len = charArray.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int a = (charArray[0] - '0') * 10 + charArray[1] - '0';
        dp[1] = a >= 10 && a <= 25 ? 2 : 1;
        for (int i = 2; i < len; i++) {
            int cur = charArray[i] - '0';
            int pre = charArray[i - 1] - '0';
            int num = pre * 10 + cur;
            if (num > 25 || pre == 0) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[len - 1];
    }
}

