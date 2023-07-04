package day2023_05_19;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/5/19 15:17
 */
public class demo3 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int lie = obstacleGrid[0].length, hang = obstacleGrid.length;
        int[][] dp = new int[hang][lie];
//      动态规划，其中dp数组代表的就是到达下标时的不同路径数目
//      首先对第一行和第一列进行赋值
//      赋值规则为：如果有石头，则为0代表不通，并且后续都不通，否则就为1. 注意：因为创建数组时默认都为0，所以直接遇见石头直接break就好了
        for (int i = 0; i < lie; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[0][i] = 1;
            } else break;

        }
        for (int i = 0; i < hang; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = 1;
            } else break;
        }

//        遍历除了第一行和第一列的数组，如果遇见石头，则说明此位置不通，直接跳过即可，因为默认为0。否则赋值为上+左的数组。
        for (int i = 1; i < hang; i++) {
            for (int j = 1; j < lie; j++) {
                if (obstacleGrid[i][j] !=1){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[hang - 1][lie - 1];
    }
}

