package month12.day26;

import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/26 12:42
 */
public class demo2 {
    public int calculate(String s) {
//        加减法取对应符合数字后入栈，乘数法取栈顶计算完在入栈
        LinkedList<Integer> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == ' ') {
                i++;
                continue;
            }
            char cur = chars[i];
            if (cur == '+' || cur == '-' || cur == '*' || cur == '/') {
                i++;
                while (i < chars.length && chars[i] == ' ') {
                    i++;
                }
            }
            int nextNum = 0;
            while (i < chars.length && Character.isDigit(chars[i])) {
                nextNum = nextNum * 10 + chars[i] - '0';
                i++;
            }
            if (cur == '-') {
                nextNum = -nextNum;
            } else if (cur == '*') {
                nextNum = stack.pop() * nextNum;
            } else if (cur == '/') {
                nextNum = stack.pop() / nextNum;
            }
            stack.push(nextNum);
        }
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}

