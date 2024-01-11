package LeetCode.month01.day11;

import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/10 12:18
 */
public class demo1 {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == 'B' && !stack.isEmpty() && stack.peek() == 'A' ||(cur == 'D'&& !stack.isEmpty() && stack.peek() == 'C')){
                stack.pop();
            }else {
                stack.push(cur);
            }
        }
        return stack.size();
    }
}

