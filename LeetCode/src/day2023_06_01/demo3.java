package day2023_06_01;


import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * https://leetcode.cn/problems/min-stack/
 * @date 2023/6/1 20:04
 */
public class demo3 {
    class MinStack {
        Stack<Integer> stack1;
        Stack<Integer> stack2;
        int min = Integer.MAX_VALUE;

        public MinStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int val) {
//            更新最小值
            if (val < min) min = val;
            stack1.push(val);
        }

        public void pop() {
            Integer pop = stack1.pop();
//            如果弹出的是最小值的花就要更新，清洗
            if (pop == min) {
                min = Integer.MAX_VALUE;
//            更新最小值
                while (!stack1.isEmpty()) {
                    Integer temp = stack1.pop();
                    if (temp < min) {
                        min = temp;
                    }
                    stack2.push(temp);
                }
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return min;
        }
    }
}

