package month09.day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/stack-of-plates-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/1 12:44
 */
public class demo3 {
    class StackOfPlates {
        //        用list集合来存贮不定量的栈
        List<Stack<Integer>> stackList;
        //        将每个栈的大小扩充为全局变量
        int size;

        public StackOfPlates(int cap) {
            stackList = new ArrayList<>();
            size = cap;
        }

        public void push(int val) {
//            特判，测试用例有cap =0的情况
            if (size <= 0) {
                return;
            }
            int lastIndex = stackList.size() - 1;
//            如果当前栈集合中没有栈或者前一个栈满了都要新开栈
            if (stackList.isEmpty() || stackList.get(lastIndex).size() == size) {
                Stack<Integer> stack = new Stack<>();
                stack.push(val);
                stackList.add(stack);
                return;
            }
//            另一种情况就是普通情况，向前一个栈添加元素即可
            stackList.get(lastIndex).push(val);
        }

        public int pop() {
//            调用 popAt方法，这里不直接返回最后一个栈的栈顶元素是因为还要特判最后一个栈是否只有一个元素，还要包括删除栈元素，所以放在一起写即可
            return popAt(stackList.size() - 1);
        }

        public int popAt(int index) {
//            特判
            if (index < 0 || index >= stackList.size() || stackList.get(index).isEmpty()) {
                return -1;
            }
            Stack<Integer> stack = stackList.get(index);
            int res = stack.pop();
            if (stack.isEmpty()) {
//                如果该栈只有一个元素，那么弹出后就变成了空栈，弹出集合
                stackList.remove(index);
            }
            return res;
        }
    }
}

