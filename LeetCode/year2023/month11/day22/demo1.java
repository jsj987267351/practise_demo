package month11.day22;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/22 12:46
 */
public class demo1 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int rowLength = grid.length;
        int colLength = grid[0].length;
//        dp[i][j]含义：到达下标i，j时的最小路径代价
        int[][] dp = new int[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
//                第0行直接可到达，最小路径就是当前值
                if (i == 0){
                    dp[i][j] = grid[i][j];
                    continue;
                }
//                其他行初始赋值max，方便后续更新
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < rowLength - 1; i++) {
            for (int j = 0; j < colLength; j++) {
                int value = grid[i][j];
                int[] cost = moveCost[value];
                int nextRow = i + 1;
                for (int k = 0; k < cost.length; k++) {
//                    下一行中每列的最小路径代价为上一行当前值的最小路径代价+到达当前下标需要的代价+当前下标的值
                    dp[nextRow][k] = Math.min(dp[nextRow][k], dp[i][j] + grid[nextRow][k] + cost[k]);
                }
            }
        }
//        最后取最后一行的最小路径代价即可
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < colLength; i++) {
            res = Math.min(res, dp[rowLength - 1][i]);
        }
        return res;
    }
}

