package day72;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/
 * @date 2023/6/28 15:00
 */
public class demo3 {
    public int findMinArrowShots(int[][] points) {
        int count = 1;
//        现根据区间的左区间升序，如果左区间相同，就按右区间升序
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] > b[1] ? 1 : -1;
            }
            return a[0] > b[0] ? 1 : -1;
        });
//        确定区间的右边界，因为已经按照左边界排序过了，所以只确定右边界即可
        int right = points[0][1];

        for (int i = 1; i < points.length; i++) {
//            如果当前的左边界大于前面确定的右边界，说明两个集合没有交集，总数+1，并且重新确定右边界
            if (points[i][0] > right) {
                count++;
                right = points[i][1];
            } else {
//                否则说明两个集合有交集，更新右边界为交集的右边界
                right = Math.min(points[i][1], right);
            }
        }
        return count;
    }


    public int findMinArrowShots1(int[][] points) {
//        使用内置排序算法
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 1;
//        确定区间的右边界，因为已经按照左边界排序过了，所以只确定右边界即可
        int right = points[0][1];

        for (int i = 1; i < points.length; i++) {
//            如果当前的左边界大于前面确定的右边界，说明两个集合没有交集，总数+1，并且重新确定右边界
            if (points[i][0] > right) {
                count++;
                right = points[i][1];
            } else {
//                否则说明两个集合有交集，更新右边界为交集的右边界
                right = Math.min(points[i][1], right);
            }
        }
        return count;
    }

}

