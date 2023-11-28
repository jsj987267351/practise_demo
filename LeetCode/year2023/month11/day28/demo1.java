package month11.day28;

import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/28 14:01
 */
public class demo1 {
    class FrontMiddleBackQueue {
        LinkedList<Integer> list1;
        LinkedList<Integer> list2;

        public FrontMiddleBackQueue() {
            list1 = new LinkedList<>();
            list2 = new LinkedList<>();
        }

        public void pushFront(int val) {
            list1.addFirst(val);
        }

        public void pushMiddle(int val) {
            int size = list1.size();
            int num = size / 2;
            while (num > 0) {
                list2.addFirst(list1.removeFirst());
                num--;
            }
            list1.addFirst(val);
            while (!list2.isEmpty()) {
                list1.addFirst(list2.removeFirst());
            }
        }

        public void pushBack(int val) {
            list1.addLast(val);
        }

        public int popFront() {
            return list1.isEmpty() ? -1 : list1.removeFirst();
        }

        public int popMiddle() {
            if (list1.isEmpty()) {
                return -1;
            }
            int size = list1.size();
            int num = size % 2 == 0 ? size / 2 - 1 : size / 2;
            while (num > 0) {
                list2.addFirst(list1.removeFirst());
                num--;
            }
            int res = list1.removeFirst();
            while (!list2.isEmpty()) {
                list1.addFirst(list2.removeFirst());
            }
            return res;
        }

        public int popBack() {
            return list1.isEmpty() ? -1 : list1.removeLast();
        }
    }
}

