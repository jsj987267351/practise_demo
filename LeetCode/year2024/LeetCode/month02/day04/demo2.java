package LeetCode.month02.day04;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/4 16:09
 */
public class demo2 {
    public int stoneGameVII(int[] stones) {
//        看收藏的解析,主要难理解的点，差值
        int length = stones.length;
//        dp[i][j]：i到j之间爱丽丝先手的差值
        int[][] dp = new int[length][length];
//       观察公式发现i和>=i有关系，j和<=j有关系，也就是右上角，确定遍历顺序
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
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

