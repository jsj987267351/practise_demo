package LeetCode.month01.day09;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/8 12:39
 */
public class demo5 {
    class FrontMiddleBackQueue {
        Deque<Integer> left;
        Deque<Integer> right;

        public FrontMiddleBackQueue() {
            left = new ArrayDeque<>();
            right = new ArrayDeque<>();
        }

        public void balance() {
            if (left.size() > right.size()) {
                right.addFirst(left.pollLast());
            } else if (right.size() > left.size() + 1) {
                left.addLast(right.pollFirst());
            }
        }

        public void pushFront(int val) {
            left.addFirst(val);
            balance();
        }

        public void pushMiddle(int val) {
            if (left.size() == right.size()) {
                right.addFirst(val);
            } else {
                left.addLast(val);
            }
        }

        public void pushBack(int val) {
            right.addLast(val);
            balance();
        }

        public int popFront() {
            if (right.isEmpty()) return -1;
            int res = left.isEmpty() ? right.pollFirst() : left.pollFirst();
            balance();
            return res;
        }

        public int popMiddle() {
            if (right.isEmpty()) return -1;
            if (left.size() == right.size()) {
                return left.pollLast();
            } else {
                return right.pollFirst();
            }
        }

        public int popBack() {
            if (right.isEmpty()) return -1;
            int res = right.pollLast();
            balance();
            return res;
        }
    }
}

