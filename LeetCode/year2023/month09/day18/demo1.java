package month09.day18;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * https://leetcode.cn/problems/max-points-on-a-line/description/
 * @date 2023/9/18 12:01
 */
public class demo1 {
    public int maxPoints(int[][] points) {
//        解题思路：暴力枚举，从头开始每两个点确定一条直线，然后判断后续点是否也在这条直线上，每次更新最大存在点数
        int len = points.length;
//        最终结果
        int res = 1;
        for (int i = 0; i < len; i++) {
//            第一个点
            int[] one = points[i];
            for (int j = i + 1; j < len; j++) {
//                第二个点
                int[] two = points[j];
//                当前两点确定的直线上最少已经有2个点了，表示当前直线上存在的点数
                int curSum = 2;
                for (int k = j + 1; k < len; k++) {
//                    第三个点，每次判断当前点是否在前两点确定的直线上，在的话存在数++，循环结束后更新最大值,利用斜率判断
//                    因为斜率用除法可能导致除数为0，因此使用对角相乘判断
                    int[] three = points[k];
                    int xielv1 = (three[1] - two[1]) * (two[0] - one[0]);
                    int xielv2 = (three[0] - two[0]) * (two[1] - one[1]);
//                    在同一条直线上，当前直线点数++
                    if (xielv1 == xielv2) curSum++;
                }
//                更新最大值
                res = Math.max(res, curSum);
            }
        }
        return res;
    }
}

