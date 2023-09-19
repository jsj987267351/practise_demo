package month09.day19;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/pond-sizes-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/19 12:31
 */
public class demo3 {
    List<Integer> list;
    int rowLength;
    int colLength;

    public int[] pondSizes(int[][] land) {
//        与 LCR 105. 岛屿的最大面积 一题解法相同，不同点就是方向变为8个方向，结果不在返回最大值而是所有值
        list = new ArrayList<>();
        rowLength = land.length;
        colLength = land[0].length;
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (land[i][j] == 0) {
//                   只有当前为水域才可进行遍历
                    list.add(getArea(land, i, j));
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res);
        return res;
    }

    public int getArea(int[][] land, int row, int col) {
//        特判
        if (row < 0 || col < 0  || row >= rowLength || col >= colLength || land[row][col] != 0) return 0;
//        将当前水域标记为已经遍历过
        land[row][col] = -1;
//        当前水域面积
        int curSum = 1;
//        当前水域加上8个方向的水域面积
        curSum += getArea(land, row - 1, col);
        curSum += getArea(land, row - 1, col + 1);
        curSum += getArea(land, row, col + 1);
        curSum += getArea(land, row + 1, col + 1);
        curSum += getArea(land, row + 1, col);
        curSum += getArea(land, row + 1, col - 1);
        curSum += getArea(land, row, col - 1);
        curSum += getArea(land, row - 1, col - 1);

        return curSum;
    }
}

