package month09.day02;

import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/implement-queue-using-stacks-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/2 12:09
 */
public class demo1 {
    class MyQueue {
        Stack<Integer> in;
        Stack<Integer> out;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            in.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (!out.isEmpty()) {
                return out.pop();
            }
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            return out.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!out.isEmpty()) {
                return out.peek();
            }
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
            return out.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }
}

