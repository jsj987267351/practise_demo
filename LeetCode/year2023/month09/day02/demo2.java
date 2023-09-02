package month09.day02;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 * @date 2023/9/2 12:11
 */
public class demo2 {
//    思路：每次放入值时，先把栈中所有小于当前放入值的数字移入辅助栈中，给新加入的值放到正确位置上后在移回来。
//    构造一个单调栈，但是不少值
    class SortedStack {
        LinkedList<Integer> main;
//        辅助栈
        LinkedList<Integer> sup;

        public SortedStack() {
            main = new LinkedList<>();
            sup = new LinkedList<>();
        }

        public void push(int val) {
            if (main.isEmpty()) {
                main.push(val);
                return;
            }
            while (!main.isEmpty() && main.peek() < val) {
                sup.push(main.pop());
            }
            main.push(val);
            while (!sup.isEmpty()) {
                main.push(sup.pop());
            }
        }

        public void pop() {
            if (!main.isEmpty()) {
                main.pop();
            }
        }

        public int peek() {
            if (!main.isEmpty()) {
                return main.peek();
            }
            return -1;
        }

        public boolean isEmpty() {
            return main.isEmpty();
        }
    }
}

