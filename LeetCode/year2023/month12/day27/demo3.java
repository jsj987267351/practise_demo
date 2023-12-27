package month12.day27;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/27 14:50
 */
public class demo3 {
    public int respace(String[] dictionary, String sentence) {
        int len = sentence.length();
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            dp[i] = dp[i - 1] + 1;
            for (String s : dictionary) {
                int length = s.length();
                if (length <= i && s.equals(sentence.substring(i - length, i))) {
                    dp[i] = Math.min(dp[i], dp[i - length]);
                }
            }
        }
        return dp[len];
    }
}

