package LeetCode.month01.day12;

import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/11 13:27
 */
public class demo1 {
    public int addMinimum(String word) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (stack.isEmpty()) {
                if (cur == 'b') {
                    stack.push('a');
                } else if (cur == 'c') {
                    stack.push('a');
                    stack.push('b');
                }
            } else {
                char top = stack.peek();
                if (cur == 'a') {
                    if (top == 'a') {
                        stack.push('b');
                        stack.push('c');
                    } else if (top == 'b') {
                        stack.push('c');
                    }
                } else if (cur == 'b') {
                    if (top == 'b') {
                        stack.push('c');
                        stack.push('a');
                    } else if (top == 'c') {
                        stack.push('a');
                    }
                } else {
                    if (top == 'a') {
                        stack.push('b');
                    } else if (top == 'c') {
                        stack.push('a');
                        stack.push('b');
                    }
                }
            }
            stack.push(cur);
        }
        int res = stack.size() - word.length();
        if (stack.peek() == 'a') {
            return res + 2;
        } else if (stack.peek() == 'b') {
            return res + 1;
        } else {
            return res;
        }
    }
}

