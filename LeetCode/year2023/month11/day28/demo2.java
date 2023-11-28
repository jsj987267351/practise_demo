package month11.day28;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/28 14:12
 */
public class demo2 {
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
//            因为每次添加都会进行平衡，右边的长度一定大于等于左边的长度，如果右边为空，说明整体都为空
            if (right.isEmpty()) {
                return -1;
            }
//            右边不为空也有可能就只有右边一个元素，所以不可直接从左头返回，要判空
            int res = left.isEmpty() ? right.pollFirst() : left.pollFirst();
            balance();
            return res;
        }

        public int popMiddle() {
//           同理判空
            if (right.isEmpty()) {
                return -1;
            }
            if (left.size() == right.size()) {
                return left.pollLast();
            } else {
                return right.pollFirst();
            }
        }

        public int popBack() {
//           同理判空
            if (right.isEmpty()) {
                return -1;
            }
            int res = right.pollLast();
            balance();
            return res;
        }
    }
}

