package month06.day13;


import java.util.Stack;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/decode-string/?envType=study-plan-v2&envId=top-100-liked
 * @date 2023/6/13 15:32
 */
public class demo2 {
    public String decodeString(String s) {
        Stack<Integer> integerStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        int num = 0;
        for (char c: s.toCharArray()){
            if (c =='['){
//                遇到左括号，将前一个数字与当前字符串都加入站
                integerStack.push(num);
                stringStack.push(res.toString());
//                数字与当前字符串都清0
                num = 0;
                res = new StringBuilder();
            }else if (c == ']'){
//                遇到右括号，取出数字栈中的元素
                int count = integerStack.pop();
//                定义临时字符串,此时的res就是数字后的字符串
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    temp.append(res);
                }
//                更新当前字符串，与字符串栈的栈顶链接形成新的字符串,并且注意应该先连接栈中的字符串
                res = new StringBuilder(stringStack.pop() + temp);
            }else if (Character.isDigit(c)){
//                数字的话，更改当前数字的变化，乘10是因为有可能该数字不是个位数，初始时num = 0
                num = num *10 + Integer.parseInt(c + "");
            }else {
//                字母直接加入当前字符串
                res.append(c);
            }
        }
        return res.toString();
    }
}

