package month09.day01;

import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 * @date 2023/9/1 12:33
 */
public class demo2 {
    class MinStack {

        /**
         * initialize your data structure here.
         */
        Stack<Integer> stack;
        Stack<Integer> stack2;
        int min;

        public MinStack() {
            stack = new Stack<>();
            stack2 = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            if (x < min) {
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            int pop = stack.pop();
//            清洗
            if (pop == min) {
                min = Integer.MAX_VALUE;
                while (!stack.isEmpty()) {
                    int pop1 = stack.pop();
                    if (pop1 < min) {
                        min = pop1;
                    }
                    stack2.push(pop1);
                }
//                在清洗回去
                while (!stack2.isEmpty()) {
                    stack.push(stack2.pop());
                }
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}

