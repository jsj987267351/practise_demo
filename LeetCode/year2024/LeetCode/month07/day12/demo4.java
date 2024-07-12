package LeetCode.month07.day12;

import java.util.ArrayDeque;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/12 9:58
 */
public class demo4 {
    class FrontMiddleBackQueue {
        ArrayDeque<Integer> front;
        ArrayDeque<Integer> back;

        public FrontMiddleBackQueue() {
            front = new ArrayDeque<>();
            back = new ArrayDeque<>();
        }

        public void balance() {
            if (front.size() > back.size()) {
                back.addFirst(front.removeLast());
            } else if (back.size() > front.size() + 1) {
                front.addLast(back.removeFirst());
            }
        }

        public void pushFront(int val) {
            front.addFirst(val);
            balance();
        }

        public void pushMiddle(int val) {
            if (front.size() == back.size()) {
                back.addFirst(val);
            } else {
                front.addLast(val);
            }
            balance();
        }

        public void pushBack(int val) {
            back.addLast(val);
            balance();
        }

        public int popFront() {
            if (back.isEmpty()) return -1;
            int res = front.isEmpty() ? back.removeFirst() : front.removeFirst();
            balance();
            return res;
        }

        public int popMiddle() {
            if (back.isEmpty()) return -1;
            int res;
            if (front.size() == back.size()) {
                res = front.removeLast();
            } else {
                res = back.removeFirst();
            }
            balance();
            return res;
        }

        public int popBack() {
            if (back.isEmpty()) return -1;
            int res = back.removeLast();
            balance();
            return res;
        }
    }
}

