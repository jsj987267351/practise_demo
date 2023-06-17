package day65;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * <p>
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 * @date 2023/6/17 19:36
 */
public class demo2 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String s : tokens) {
            if (s.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if (s.equals("-")){
                stack.push(-stack.pop() + stack.pop());
            }else if (s.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if (s.equals("/")){
                Integer back = stack.pop();
                Integer front = stack.pop();
                stack.push(front / back);
            }else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}

