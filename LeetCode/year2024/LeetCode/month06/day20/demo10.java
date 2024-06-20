package LeetCode.month06.day20;

import java.util.ArrayDeque;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/20 11:23
 */
public class demo10 {

    class MyQueue {
        ArrayDeque<Integer> deque;

        public MyQueue() {
            deque = new ArrayDeque<>();
        }

        public int getMax() {
            return deque.getFirst();
        }

        public void remove(int num) {
            if (num == deque.getFirst()) {
                deque.removeFirst();
            }
        }

        public void add(int num) {
            while (!deque.isEmpty() && num > deque.getLast()) {
                deque.removeLast();
            }
            deque.addLast(num);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        int index = 0;
        res[index++] = myQueue.getMax();
        for (int i = k; i < nums.length; i++) {
            myQueue.remove(nums[i - k]);
            myQueue.add(nums[i]);
            res[index++] = myQueue.getMax();
        }
        return res;
    }
}

