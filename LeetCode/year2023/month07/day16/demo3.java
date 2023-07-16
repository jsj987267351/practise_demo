package month07.day16;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/16 12:36
 */
public class demo3 {
    class MaxQueue1 {
        Queue<Integer> queue;
        Deque<Integer> deque;

        public MaxQueue1() {
            queue = new LinkedList<>();
//            模拟一个单调队列  与239题同理
            deque = new LinkedList<>();
        }

        public int max_value() {
            if (queue.isEmpty()) {
                return -1;
            }
            return deque.peek();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!deque.isEmpty() && deque.getLast() < value) {
                deque.removeLast();
            }
            deque.add(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int poll = queue.poll();
            if (!deque.isEmpty() && poll == deque.peek()) {
                deque.pop();
            }
            return poll;
        }
    }


    class MaxQueue {
//        用两个队列进行清洗
        Queue<Integer> queue;
        Queue<Integer> queue2;
        int max;

        public MaxQueue() {
            queue = new LinkedList<>();
            queue2 = new LinkedList<>();
            max = -1;
        }

        public int max_value() {
            if (queue.isEmpty()){
                return -1;
            }
            return max;
        }

        public void push_back(int value) {
            if (value > max) {
                max = value;
            }
            queue.add(value);
        }

        public int pop_front() {
            if (queue.isEmpty()){
                return -1;
            }
//            如果弹出的是max，就要清洗队列，清洗的过程中重新选择最大值
            int poll = queue.poll();
            if (max == poll) {
                max = -1;
                while (!queue.isEmpty()) {
                    int pol = queue.poll();
                    if (pol > max) {
                        max = pol;
                    }
                    queue2.add(pol);
                }
                while (!queue2.isEmpty()) {
                    queue.add(queue2.poll());
                }
            }
            return poll;
        }
    }
}

