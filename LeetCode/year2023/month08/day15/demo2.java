package month08.day15;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * https://leetcode.cn/problems/maximal-square/description/?envType=study-plan-v2&envId=top-interview-150
 * @date 2023/8/15 17:36
 */
public class demo2 {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
//        dp[i][j]表示以matrix[i][j]为右下角的正方形的最大边长
        int[][] dp = new int[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (matrix[i][j] == '1') {
//                    只有当前元素为1时才计算，因为为0的话以当前元素为右下角组不成正方形
                    if (i == 0 || j == 0) {
//                        如果是第一行或者第一列那么只能组成1*1的正方形，边长为1
                        dp[i][j] = 1;
                    } else {
//                        以当前元素为正方形的右下角想组成更大正方形的话，那么以他的左上，左和上为底必须是能组成正方形，有一个组不成的话那么以当前为底就不可能组成更大的，只能组成边长为1的正方形
//                        这里取最小值是因为要与三个方向都能组成，可以理解为扩大正方形面积的话需要向这三个方向进行扩展，扩展的同时要满足是正方形，所以当一个方向扩展到不满足时这个正方形就已经达到最大了
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
//                    更新最大边长
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}

