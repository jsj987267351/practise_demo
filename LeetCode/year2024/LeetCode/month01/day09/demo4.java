package LeetCode.month01.day09;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/8 12:25
 */
public class demo4 {
    class FrontMiddleBackQueue {
        Deque<Integer> list1;
        Deque<Integer> list2;

        public FrontMiddleBackQueue() {
            list1 = new ArrayDeque<>();
            list2 = new ArrayDeque<>();
        }

        public void pushFront(int val) {
            list1.addFirst(val);
        }

        public void pushMiddle(int val) {
            int size = list1.size();
            for (int i = 0; i < size / 2; i++) {
                list2.addFirst(list1.pollFirst());
            }
            list1.addFirst(val);
            while (!list2.isEmpty()) {
                list1.addFirst(list2.pollFirst());
            }
        }

        public void pushBack(int val) {
            list1.addLast(val);
        }

        public int popFront() {
            return list1.isEmpty() ? -1 : list1.pollFirst();
        }

        public int popMiddle() {
            if (list1.isEmpty()) return -1;
            int size = list1.size();
            int pollSize;
            if (size % 2 == 0) {
                pollSize = size / 2 - 1;
            } else {
                pollSize = size / 2;
            }
            for (int i = 0; i < pollSize; i++) {
                list2.addFirst(list1.pollFirst());
            }
            int res = list1.pollFirst();
            while (!list2.isEmpty()){
                list1.addFirst(list2.pollFirst());
            }
            return res;
        }

        public int popBack() {
            return list1.isEmpty() ? -1 : list1.pollLast();
        }
    }
}

