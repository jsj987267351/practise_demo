package month07.day13;

import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * https://leetcode.cn/problems/largest-rectangle-in-histogram/
 * @date 2023/7/13 12:58
 */
public class demo2 {
    public int largestRectangleArea1(int[] heights) {
//        定义新数组，新数组两边加0，其余直接复制
//        原因是用到单调递减栈，要找到每个元素两边第一个比他小的元素，不加0的话有可能原先数组是递增的会一直入栈，而且没法以两边为底的面积
        int[] newHeight = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeight, 1, heights.length);
        newHeight[heights.length + 1] = 0;
        newHeight[0] = 0;
        int res = 0;

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);

        for (int i = 1; i < newHeight.length; i++) {
            while (!stack.isEmpty() && newHeight[stack.peek()] > newHeight[i]) {
//                如果遇到比栈口小的，说明遇到了右边第一个比栈口元素小的
                int mid = stack.pop();
                if (!stack.isEmpty()) {
                    int left = stack.peek();
//                    此时left为左边第一个比mid小的下标，i为右边第一个比mid小的下标
//                    所以以left+1 到 i+1下标为矩阵的长，mid的高度为矩阵高,就是以newHeight[mid]为底的最大矩阵面积
                    int height = newHeight[mid];
                    int board = i - left - 1;
                    res = Math.max(res, height * board);
                }
            }
            stack.push(i);
        }
        return res;
    }

    public int largestRectangleArea(int[] heights) {
//        定义新数组，新数组两边加0，其余直接复制
//        原因是用到单调递减栈，要找到每个元素两边第一个比他小的元素，不加0的话有可能原先数组是递增的会一直入栈，而且没法以两边为底的面积
        int[] newHeight = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeight, 1, heights.length);
        newHeight[heights.length + 1] = 0;
        newHeight[0] = 0;

        int res = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);

        for (int i = 1; i < newHeight.length; i++) {
//            这里不用判断栈为空，因为左边加的0一定是最小值，永远不会被取出来
            while (newHeight[stack.peek()] > newHeight[i]) {
//                如果遇到比栈口小的，说明遇到了右边第一个比栈口元素小的
                int mid = stack.pop();
//                同理不用判断栈空，因为最左边的0一定在栈里
                int left = stack.peek();
//                    此时left为左边第一个比mid小的下标，i为右边第一个比mid小的下标
//                    所以以left+1 到 i+1下标为矩阵的长，mid的高度为矩阵高,就是以newHeight[mid]为底的最大矩阵面积
                int height = newHeight[mid];
                int board = i - left - 1;
                res = Math.max(res, height * board);

            }
            stack.push(i);
        }
        return res;
    }
}

