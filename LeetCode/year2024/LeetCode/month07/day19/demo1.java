package LeetCode.month07.day19;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/19 9:40
 */
public class demo1 {
    public static void main(String[] args) {
        int [] a = {1,1,1,1,1};
        System.out.println(minimumLevels(a));
    }
    public static int minimumLevels(int[] possible) {
        int len = possible.length;
        int[] dp = new int[len];
        dp[0] = possible[0] == 0 ? -1 : 1;
        int sum = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i - 1] + (possible[i] == 0 ? -1 : 1);
            sum += possible[i] == 0 ? -1 : 1;
        }
        for (int i = 0; i < len -1; i++) {
            int Alice = dp[i];
            int bob = sum - Alice;
            if (Alice > bob) {
                return i + 1;
            }
        }
        return -1;
    }
}

