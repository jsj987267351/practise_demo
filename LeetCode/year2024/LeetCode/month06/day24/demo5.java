package LeetCode.month06.day24;

import java.util.ArrayDeque;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/24 10:29
 */
public class demo5 {

    public static void main(String[] args) {
        String s = decodeString("3[a2[c]]");
        System.out.println(s);
    }
    public  static String decodeString(String s) {
        ArrayDeque<String> StringStack = new ArrayDeque<>();
        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                numStack.push(num);
                num = 0;
                StringStack.push(res.toString());
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder sb = new StringBuilder();
                int count = numStack.pop();
                for (int i = 0; i < count; i++) {
                    sb.append(res);
                }
                res = new StringBuilder(StringStack.pop() + sb);

            } else if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}

