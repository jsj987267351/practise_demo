package day2023_03_31;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * @date 2023/3/31 15:14
 * https://leetcode.cn/problems/implement-stack-using-queues/
 */

public class demo3 {
    public class MyStack {
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        public MyStack() {
            queue1 = new LinkedList<Integer>();
            queue2 = new LinkedList<Integer>();
        }

        public void push(int x) {
            queue2.offer(x);
            while (!queue1.isEmpty()){
                queue2.offer(queue1.poll());
            }
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
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

