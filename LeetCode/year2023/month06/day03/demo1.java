package month06.day03;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * https://leetcode.cn/problems/sliding-window-maximum/?envType=study-plan-v2&envId=top-100-liked
 * @date 2023/6/3 20:08
 */
public class demo1 {
    public class MyQueue {
        //        定义双端队列模拟单调队列
        Deque<Integer> deque = new LinkedList<>();

        //        弹出，队列头部保存当前队列的最大值，如果要弹出的值等于头部的值的时候才弹出，否则她就一直是窗口中的最大值
        public void poll(int value) {
            if (!deque.isEmpty() && value == deque.peek()) {
                deque.poll();
            }
        }

        //     添加，从后添加，从后往前遍历队列，把小于要添加的值的值全部弹出，来保证队列是单调队列
        //     不必担心弹多，因为当前加入的值一定是该窗口中的值，所以最多把头部元素也弹出，那他就是最大值，也就是范围有效
        public void push(int value) {
            while (!deque.isEmpty() && deque.getLast() < value) {
                deque.removeLast();
            }
            deque.add(value);
        }

        //        最大值就是出口处的值
        public int getMax() {
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        MyQueue myQueue = new MyQueue();
//        先将第一个窗口的值全部加入，根据定义的规则，队列头部就是该窗口的最大值
        for (int i = 0; i < k; i++) {
            myQueue.push(nums[i]);
        }
//        结果数组的下标
        int index = 0;
        result[index++] = myQueue.getMax();
//        运用单调队列
        for (int i = k; i < nums.length; i++) {
//            每次把窗口最左边的值poll掉
            myQueue.poll(nums[i-k]);
//            将窗口右移，把右边一个元素push进队列进行重新排列
            myQueue.push(nums[i]);
//            这时单调队列的队头元素就是窗口的最大值
            result[index++] = myQueue.getMax();
        }
        return result;
    }
}

