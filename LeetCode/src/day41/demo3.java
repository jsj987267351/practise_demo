package day41;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 * 链接：https://leetcode.cn/problems/unique-paths
 * @date 2023/5/12 13:10
 */
public class demo3 {
    public int uniquePaths(int m, int n) {
//        特殊情况判断
        if (m==1 || n==1){
            return 1;
        }
//        动态规划数组，数组中的每个值的含义代表到达该位置时有多少种走法
        int[][] dp = new int[m][n];
//        开始将第一行和第1列方法全部设置为1，因为题目只能向右和向下走，所以最上面和最下边都只有一种直接的走法
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
//       遍历数组，到达每个地方的方法数等于从下和从左两个位置的方法的总和  所以遍历顺序为从上到下，从左到右
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        System.out.println("testgit");
//        最右下角数组的数则是最终结果
        return dp[m-1][n-1];
    }
}

