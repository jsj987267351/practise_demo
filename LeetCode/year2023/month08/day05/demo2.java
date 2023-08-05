package month08.day05;

import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/8/5 19:10
 */
public class demo2 {
    public int minimumTotal1(List<List<Integer>> triangle) {
        int length = triangle.size();
//        dp[i][j]含义：到达第i层第j个位置的最小值
        int[][] dp = new int[length][length];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < length; i++) {
//            每行的第一个数字只能由上一个过来
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
//                只能由上面和左上方得来
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
//            每行的最后一个数字只能由左上方得来
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
//        求出到达最后一层的最小值即可
        int res = dp[length - 1][0];
        for (int i = 1; i < length; i++) {
            res = Math.min(res, dp[length - 1][i]);
        }
        return res;
    }

}

