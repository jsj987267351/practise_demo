package month07.day21;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个数组 points 和一个整数 k 。数组中每个元素都表示二维平面上的点的坐标，并按照横坐标 x 的值从小到大排序。也就是说 points[i] = [xi, yi] ，并且在 1 <= i < j <= points.length 的前提下， xi < xj 总成立。
 * <p>
 * 请你找出 yi+ yj+ |xi- xj| 的 最大值，其中 |xi- xj|<= k 且 1 <= i < j <= points.length。
 * <p>
 * 题目测试数据保证至少存在一对能够满足 |xi- xj|<= k 的点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/max-value-of-equation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/21 13:32
 */
public class demo1 {
    public int findMaxValueOfEquation(int[][] points, int k) {
//        yi + yj + |xi - xj|
//      = (xj + yj) + (yi - xi)
//        即求满足要求且yi - xi的最大值
        int res = Integer.MIN_VALUE;

//        单调队列，队列中存放的元素都是一个长度为2的数组
//        第一位为x，第二位为y-x  按照第二位单调递减，保证头部是最大
        Deque<int[]> queue = new ArrayDeque<>();
        for (int[] point : points) {
            int x = point[0], y = point[1];
//            因为题目给的x坐标是递增的，所以遍历的时候把x不符合要求的都直接弹出，因为当前不符合要求，后续一定也不符合要求，因为是递增的x
            while (!queue.isEmpty() && x - queue.peekFirst()[0] > k) {
                queue.pollFirst();
            }
//            单调队列的队首一定是符合要求中的y-x最大值，进行更新
            if (!queue.isEmpty()) {
                res = Math.max(res, x + y + queue.peekFirst()[1]);
            }
//            插入时保证队列是单调的
            while (!queue.isEmpty() && y - x >= queue.peekLast()[1]) {
                queue.pollLast();
            }
            queue.addLast(new int[]{x, y - x});
        }
        return res;
    }
}

