package month11.day30;

import java.util.ArrayDeque;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/30 11:59
 */
public class demo2 {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String s : split) {
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (s.length() > 0 && !".".equals(s)) {
                stack.offerLast(s);
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

