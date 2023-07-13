package month07.day13;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * <p>
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-falling-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/13 12:30
 */
public class demo1 {
    public int minFallingPathSum1(int[][] matrix) {
        int length = matrix.length;
//        dp[i][j]：表示到达matrix[i][j]的最小和
        int[][] dp = new int[length][length];

//        初始化  第一行都等于对应数组值
        for (int col = 0; col < length; col++) {
            dp[0][col] = matrix[0][col];
        }

//        从第二行还是遍历
        for (int row = 1; row < length; row++) {
            for (int col = 0; col < length; col++) {
//                第一列和最后一列特判
//                第一列的最小值只能从上方和右上方下来
                if (col == 0) {
                    dp[row][col] = matrix[row][col] + Math.min(dp[row - 1][col], dp[row - 1][col + 1]);
                } else if (col == length - 1) {
//                最后一列只能从左上方和上方下来
                    dp[row][col] = matrix[row][col] + Math.min(dp[row - 1][col], dp[row - 1][col - 1]);
                } else {
//                其他列可以从左上方，正上方，右上方三个方向下来
                    dp[row][col] = matrix[row][col] + Math.min(Math.min(dp[row - 1][col], dp[row - 1][col - 1]), dp[row - 1][col + 1]);
                }
            }
        }

//        最后返回最后一行的最小值即可
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            min = Math.min(min, dp[length - 1][i]);
        }
        return min;
    }

    public int minFallingPathSum(int[][] matrix) {
//          思路一致，只不过直接原地dp
        int length = matrix.length;
        int res = Integer.MAX_VALUE;
//        从第一行开始
        for (int row = 1; row < length; row++) {
            for (int col = 0; col < length; col++) {
                if (col == 0) {
                    matrix[row][col] += Math.min(matrix[row - 1][col], matrix[row - 1][col + 1]);
                } else if (col == length - 1) {
                    matrix[row][col] += Math.min(matrix[row - 1][col], matrix[row - 1][col - 1]);
                } else {
                    matrix[row][col] += Math.min(Math.min(matrix[row - 1][col], matrix[row - 1][col + 1]), matrix[row - 1][col - 1]);
                }
            }
        }

        for (int i = 0; i < length; i++) {
            res = Math.min(res, matrix[length - 1][i]);
        }

        return res;
    }
}

