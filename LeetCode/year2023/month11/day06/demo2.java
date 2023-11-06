package month11.day06;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/6 12:28
 */
public class demo2 {
    public class myQueue {
        Deque<Integer> deque = new ArrayDeque<>();
        public void push(int num) {
            while (!deque.isEmpty() && deque.getLast()< num) {
                deque.removeLast();
            }
            deque.addLast(num);
        }

        public void remove(int num) {
            if (deque.getFirst() == num) {
                deque.removeFirst();
            }
        }

        public int getMax() {
            return deque.getFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        int[] res = new int[length - k + 1];
        myQueue myQueue = new myQueue();
        for (int i = 0; i < k; i++) {
            myQueue.push(nums[i]);
        }
        res[0] = myQueue.getMax();
        int index = 1;
        for (int i = k; i < nums.length; i++) {
            myQueue.remove(nums[i - k]);
            myQueue.push(nums[i]);
            res[index++] = myQueue.getMax();
        }
        return res;
    }
}

