package LeetCode.month06.day18;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/18 14:34
 */
public class demo11 {
//    public int stoneGameVII(int[] stones) {
//        int length = stones.length;
//        int[][] dp = new int[length][length];
//        for (int i = length - 2; i >= 0; i--) {
//            for (int j = i + 1; j < length; j++) {
//                if (i + 1 == j) {
//                    dp[i][j] = Math.max(stones[i], stones[j]);
//                } else {
//                    int left = Math.min(stones[i + 1] + dp[i + 2][j], stones[j] + dp[i + 1][j - 1]);
//                    int right = Math.min(stones[i] + dp[i + 1][j - 1], stones[j - 1] + dp[i][j - 2]);
//                    dp[i][j] = Math.max(left, right);
//                }
//            }
//        }
//        return dp[0][length - 1];
//    }

    public int stoneGameVII(int[] stones) {
        int length = stones.length;
        int[][] dp = new int[length][length];
        for (int j = 1; j < length; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (i + 1 == j) {
                    dp[i][j] = Math.max(stones[i], stones[j]);
                } else {
                    int left = Math.min(stones[i + 1] + dp[i + 2][j], stones[j] + dp[i + 1][j - 1]);
                    int right = Math.min(stones[i] + dp[i + 1][j - 1], stones[j - 1] + dp[i][j - 2]);
                    dp[i][j] = Math.max(left, right);
                }

            }
        }
        return dp[0][length - 1];
    }
}

