package month04.day14;

import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）
 * https://leetcode.cn/problems/implement-queue-using-stacks/
 * @date 2023/4/14 14:51
 */
public class demo2 {

    class MyQueue {

        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack2.push(x);
        }

        public int pop() {
            if (!stack1.isEmpty()) {
                return stack1.pop();
            }
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return stack1.pop();
        }

        public int peek() {
            if (!stack1.isEmpty()) {
                return stack1.peek();
            }
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return stack1.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}

