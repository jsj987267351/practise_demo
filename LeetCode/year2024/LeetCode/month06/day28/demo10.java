package LeetCode.month06.day28;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/28 10:58
 */
public class demo10 {
    class StackOfPlates {
        List<ArrayDeque<Integer>> list;
        int size;

        public StackOfPlates(int cap) {
            list = new ArrayList<>();
            size = cap;
        }

        public void push(int val) {
            if (size <= 0) return;
            int index = list.size() - 1;
            if (list.isEmpty() || list.get(index).size() == size) {
                ArrayDeque<Integer> stack = new ArrayDeque<>();
                stack.push(val);
                list.add(stack);
                return;
            }
            list.get(index).push(val);
        }

        public int pop() {
            return popAt(list.size() - 1);
        }

        public int popAt(int index) {
            if (index < 0 || index >= list.size() || list.get(index).isEmpty()) return -1;
            ArrayDeque<Integer> stack = list.get(index);
            int res = stack.pop();
            if (stack.isEmpty()) {
                list.remove(index);
            }
            return res;
        }
    }
}

