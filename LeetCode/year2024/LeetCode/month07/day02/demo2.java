package LeetCode.month07.day02;

import java.util.ArrayDeque;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/2 9:40
 */
public class demo2 {
    public String simplifyPath(String path) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] split = path.split("/");
        for (String s : split) {
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (s.length() > 0 && !".".equals(s)) {
                stack.addLast(s);
            }
        }
        StringBuilder res = new StringBuilder();
        if (stack.isEmpty()) {
            res.append("/");
        } else {
            while (!stack.isEmpty()) {
                res.append("/").append(stack.pollFirst());
            }
        }
        return res.toString();
    }
}

