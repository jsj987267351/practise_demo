package day13;

import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * @date 2023/3/31 13:20
 * https://leetcode.cn/problems/valid-parentheses/
 */
public class demo1 {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c =='(' ){
                stack.push(')');
            }else if (c =='['){
                stack.push(']');
            }else if (c == '{'){
                stack.push('}');
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if (pop != c){
                    return  false;
                }
            }
        }
        if (!stack.isEmpty()){
            return false;
        }
        return true;
    }
}

