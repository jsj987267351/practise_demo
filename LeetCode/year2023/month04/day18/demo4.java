package month04.day18;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)
 * https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @date 2023/4/18 13:43
 */
public class demo4 {
    class MinStack1 {
        Stack<Integer> stack;
        List<Integer> list;
        /**
         * initialize your data structure here.
         */
        public MinStack1() {
            stack  = new Stack<>();
            list = new ArrayList<>();
        }

        public void push(int x) {
            stack.push(x);
            list.add(x);

        }

        public void pop() {
            stack.pop();
            list.remove(list.size()-1);
        }

        public int top() {
            return stack.peek();

        }

        public int min() {
            return Collections.min(list);
        }
    }


    class MinStack {

        int min = Integer.MAX_VALUE;
        Stack<Integer> stack;
        Stack<Integer> stack2;
        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack  = new Stack<>();
            stack2 = new Stack<>();

        }

        public void push(int x) {
            if (x < min){
                min = x;
            }
            stack.push(x);

        }

        public void pop() {
            Integer pop = stack.pop();
            if (pop ==min){
                min = Integer.MAX_VALUE;
                while (!stack.isEmpty()){
                    Integer pop1 = stack.pop();
                    if (pop1 <min){
                        min = pop1;
                    }
                    stack2.push(pop1);
                }
                while (!stack2.isEmpty()){
                    stack.push(stack2.pop());
                }
            }
        }

        public int top() {
            return stack.peek();

        }

        public int min() {
            return min;
        }
    }
}

