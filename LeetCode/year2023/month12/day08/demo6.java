package month12.day08;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/8 14:34
 */
public class demo6 {
    class StackOfPlates {
        List<Stack<Integer>> stackList;
        int size;

        public StackOfPlates(int cap) {
            stackList = new ArrayList<>();
            size = cap;
        }

        public void push(int val) {
            if (size <= 0) {
                return;
            }
            int lastIndex = stackList.size() - 1;
            if (stackList.isEmpty() || stackList.get(lastIndex).size() == size) {
                Stack<Integer> stack = new Stack<>();
                stack.push(val);
                stackList.add(stack);
                return;
            }
            stackList.get(lastIndex).push(val);
        }

        public int pop() {
            return popAt(stackList.size()-1);
        }

        public int popAt(int index) {
            if (index < 0 || index >= stackList.size()) {
                return -1;
            }
            int res = stackList.get(index).pop();
            if (stackList.get(index).isEmpty()) {
                stackList.remove(index);
            }
            return res;
        }
    }
}

