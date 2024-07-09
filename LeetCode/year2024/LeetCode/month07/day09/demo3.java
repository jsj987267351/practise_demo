package LeetCode.month07.day09;

import java.util.LinkedList;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/9 9:48
 */
public class demo3 {
    public int calculate(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        char[] charArray = s.trim().toCharArray();
        int index = 0;
        while (index < charArray.length) {
            while (index < charArray.length && charArray[index] == ' ') {
                index++;
            }
            char cur = charArray[index];
            if (cur == '+' || cur == '-' || cur == '*' || cur == '/') {
                index++;
                while (index < charArray.length && charArray[index] == ' ') {
                    index++;
                }
            }
            int num = 0;
            while (index < charArray.length && Character.isDigit(charArray[index])) {
                num = num * 10 + charArray[index++] - '0';
            }
            if (cur == '-') {
                num = -num;
            } else if (cur == '*') {
                num = stack.pop() * num;
            } else if (cur == '/') {
                num = stack.pop() / num;
            }
            stack.push(num);
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}

