package month06.day05;

import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/6/5 14:50
 */
public class demo2 {
    public int trap1(int[] height) {
//        单调栈,横向求解。求出左边第一个比该值大的与右边第一个比该值大的，求出面积即为以该值为底的面积
//        定义单调栈，站内存放数组下标
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(0);
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
//            栈不为空并且栈顶下标的值比当前下标值小时弹出，表示找到了右边第一个比该值大的
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
//                弹出值为中间值，遍历值为右边第一个大的
                int mid = stack.pop();
//                弹出后栈顶就是左边第一个大的
                if (stack.peek() != null) {
                    int left = stack.peek();
//                横向面积为左右第一个大的值中的最小值减去中间值即为高，下标差值即为宽
                    int height2 = Math.min(height[left], height[i]) - height[mid];
                    int board = i - left - 1;
                    sum += height2 * board;
                }
            }
//            循环结束后说明当前值比左边大的已经找完，入栈
            stack.push(i);
        }
        return sum;
    }

    public int trap(int[] height) {
//          动态规划，求出当前坐标左边最高的柱子以及右边最高的柱子，如果两个柱子的最小值都小于当前柱子，说明当前柱子上面不能储水
//          否则当前柱子上面就能储水，储水的容量为左右最高中的最小值减去当前柱子的高度个单位
        int length = height.length;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        int sum = 0;
//        首先求左边高度，不包括当前值,所以i=1开始，height.length-2结束，因为两边肯定无法储水
        for (int i = 1; i < length - 1; i++) {
//            左边高度的最大值即为i-1的左边高度最大值和i-1的值的最大值
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
//        相似的求右边最大高度
        for (int i = length - 2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
//        求出左右两边高度最大值中的最小值进行判断
        for (int i = 1; i < length - 1; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }
        return sum;
    }
}

