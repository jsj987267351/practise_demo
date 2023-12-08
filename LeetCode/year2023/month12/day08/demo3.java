package month12.day08;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/8 13:57
 */
public class demo3 {
    public int crackNumber(int ciphertext) {
        String s = String.valueOf(ciphertext);
        int length = s.length();
        if (length < 2) {
            return length;
        }
        int[] dp = new int[length];
        dp[0] = 1;
        int firstDouble = Integer.parseInt(s.substring(0, 2));
        dp[1] = firstDouble >= 10 && firstDouble <= 25 ? 2 : 1;
        for (int i = 2; i < length; i++) {
            int num = Integer.parseInt(s.substring(i - 1, i + 1));
            if (num >= 10 && num < 25) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[length - 1];
    }
}

