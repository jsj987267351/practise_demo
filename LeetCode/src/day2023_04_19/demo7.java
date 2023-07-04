package day2023_04_19;

import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 * 链接：https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string
 * @date 2023/4/19 17:21
 */
public class demo7 {
    public String removeDuplicates1(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length() - 1; ) {
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                sb.delete(i, i + 2);
                if (i > 0) {
                    i--;
                }
            } else {
                i++;
            }
        }
        return sb.toString();
    }


    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < s.length()){
            if (stack.isEmpty()){
                stack.push(s.charAt(i));
            }else {
                if (stack.peek() == s.charAt(i)){
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
            }
            i++;
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}

