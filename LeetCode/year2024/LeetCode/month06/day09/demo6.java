package LeetCode.month06.day09;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/9 18:15
 */
public class demo6 {
    class MyStack {

        Queue<Integer> queue1;
        Queue<Integer> queue2;
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int x) {
            while (!queue1.isEmpty()){
                queue2.add(queue1.poll());
            }
            queue1.add(x);
            while (!queue2.isEmpty()){
                queue1.add(queue2.poll());
            }
        }

        public int pop() {
            return queue1.poll();
        }

        public int top() {
            return queue1.peek();
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }
}

