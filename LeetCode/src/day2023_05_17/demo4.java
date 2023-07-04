package day2023_05_17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * https://leetcode.cn/problems/minimum-path-sum/
 * @date 2023/5/17 17:44
 */
public class demo4 {
    //    解题思路：动态规划，其中dp数组代表的是到达指定下标需要的最小数字总和。
//    因为只能向右和向下走，所以第一行和第一列的值就是前面值之和。
//    然后dp的值为数组当前值加上上面或者左边的最小值。因为只能从这两个方向过来
    public int minPathSum1(int[][] grid) {
        int hang = grid.length, lie = grid[0].length;
        int[][] dp = new int[hang][lie];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < lie; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < hang; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < hang; i++) {
            for (int j = 1; j < lie; j++) {
                dp[i][j] = Math.min(grid[i][j] + dp[i][j - 1], grid[i][j] + dp[i - 1][j]);
            }
        }
        return dp[hang - 1][lie - 1];
    }

    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) {
//                    第一行
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
//                    第一列
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}

