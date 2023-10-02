package month10.day02;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/max-black-square-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/10/2 14:41
 */
public class demo2 {
    public int[] findSquare(int[][] matrix) {
//        题目只需要正方形的四条边边为0即可
        int len = matrix.length;
//        动态规划，其中dp[i][j][0]代表包括matrix[i][j]本身及其左边的连续0的个数，dp[i][j][1]为包括本身的上方的连续为0的个数
        int[][][] dp = new int[len][len][2];
//        最终结果
        int r = -1, c = -1, size = 0;
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
//                只有当前格子为0才有必要更新，包括本身左边连续为0的个数即为 包括左边本身左边连续为0的个数+1，上边同理
                if (matrix[row][col] == 0) {
//                    因为有可能当前格子为边缘，所以要判断索引边界
                    dp[row][col][0] = 1 + (col > 0 ? dp[row][col - 1][0] : 0);
                    dp[row][col][1] = 1 + (row > 0 ? dp[row - 1][col][1] : 0);
                }
//                因为遍历方向为从左到右，从上到下，所以遍历到当前节点的时候，其左上方已经遍历完毕了，所以可以判断以当前节点为正方形的右下角时的最大子方阵了
//                以当前节点为右下角，其正方形的最大边长为左边连续0以及上方连续0的最小值,并且遍历的边长要比更长才有遍历的必要
                for (int side = Math.min(dp[row][col][0], dp[row][col][1]); side > size; side--) {
//                    此时已经确定了该正方形的下边和右边，然后要判断上边和左边的长度是否足够
//                    上方的长度可由右上角顶点的左边连续0判断，左方可由左下角的上方连续0判断,两条边要同时满足,这里+1是因为我们统计时长度包括了本身
                    if (dp[row - side + 1][col][0] >= side && dp[row][col - side + 1][1] >= side ) {
                        size = side;
//                        此时的左上角坐标即为r和c的坐标
                        r = row - side + 1;
                        c = col - side + 1;
//                        因为我们长度是从大到小遍历，所以只要找到符合要求的就可以当前循环
                        break;
                    }
                }
            }
        }
//        首先判断是否找到
        if (r == -1) return new int[]{};
        return new int[]{r, c, size};
    }
}

