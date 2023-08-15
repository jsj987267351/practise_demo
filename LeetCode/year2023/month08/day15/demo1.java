package month08.day15;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/simplify-path/description/?envType=study-plan-v2&envId=top-interview-150
 * @date 2023/8/15 17:07
 */
public class demo1 {
    public String simplifyPath(String path) {
//        linux语法，遇到两个点遇到上一级目录，遇到一个点不变在当前目录，其他非空就是进入文件夹
//        目的就是省略其中的前进后退重复语法，简单化进入目标文件夹
        String[] names = path.split("/");
        StringBuilder res = new StringBuilder();
//        栈中存放的是当前进入的路径
        Deque<String> stack = new ArrayDeque<>();
        for (String name : names) {
//            两个点的话就要退出当前目录到上一级目录
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() >= 1 && !".".equals(name)) {
//                一个点与空都跳过，其他都是进入目录
                stack.offerLast(name);
            }
        }
//      最后从头拼接即可
        if (stack.isEmpty()) {
            res.append("/");
        } else {
            while (!stack.isEmpty()) {
                res.append("/");
                res.append(stack.pollFirst());
            }
        }
        return res.toString();
    }
}

