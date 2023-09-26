package month09.day26;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/get-kth-magic-number-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/26 13:32
 */
public class demo4 {
    public int getKthMagicNumber(int k) {
//    与丑数解法相同
        int[] dp = new int[k + 1];
        dp[1] = 1;
        int p3 = 1, p5 = 1, p7 = 1;
        for (int i = 2; i <= k; i++) {
            int num3 = dp[p3] * 3, num5 = dp[p5] * 5, num7 = dp[p7] * 7;
            int num = Math.min(num3, Math.min(num5, num7));
            dp[i] = num;
            if (num == num3) {
                p3++;
            }
            if (num == num5) {
                p5++;
            }
            if (num == num7) {
                p7++;
            }
        }
        return dp[k];
    }
}

