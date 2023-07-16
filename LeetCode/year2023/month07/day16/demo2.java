package month07.day16;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/7/16 12:20
 */
public class demo2 {

    class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        public void poll(int value) {
            if (!deque.isEmpty() && value == deque.peek()) {
                deque.poll();
            }
        }

        public void add(int num) {
            while (!deque.isEmpty() && deque.getLast() < num) {
                deque.removeLast();
            }
            deque.add(num);
        }

        public int getMax() {
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue myQueue = new MyQueue();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        int index = 0;
        res[index++] = myQueue.getMax();
        for (int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i - k]);
            myQueue.add(nums[i]);
            res[index++] = myQueue.getMax();
        }

        return res;
    }
}

