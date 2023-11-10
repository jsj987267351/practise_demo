package month11.day10;

import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/10 13:31
 */
public class demo2 {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                numStack.push(num);
                stringStack.push(res.toString());
                res = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                int count = numStack.pop();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(stringStack.pop() + temp);
            } else if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}

