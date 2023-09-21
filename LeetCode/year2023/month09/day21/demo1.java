package month09.day21;

import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/calculator-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/21 13:24
 */
public class demo1 {
    public int calculate(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
//        因为字符串可能开头结尾有空格，所以需要trim一下，转换为数组
        char[] chars = s.trim().toCharArray();
        int res = 0, i = 0, num = 0;
        while (i < chars.length) {
//            中间可能也有空格，要跳过处理
            if (chars[i] == ' ') {
                i++;
                continue;
            }
            char tmp = chars[i];
//            如果遇到的是运算符号，先取出运算符号后面的数字
            if (tmp == '*' || tmp == '-' || tmp == '+' || tmp == '/') {
                i++;
//                同样处理符号之间的空格问题
                while (i < chars.length && chars[i] == ' ') {
                    i++;
                }
            }
//            此时下标i一定为数字，但有可能不只是个位数，所以处理完毕之后num就是运算符后面的完整数字
            num = 0;
            while (i < chars.length && Character.isDigit(chars[i])) {
                num = num * 10 + chars[i] - '0';
                i++;
            }
//            判断运算符号，如果是+的话直接入栈，-的话要入栈为其相反数，因为最后对栈内数字求和运算
//            *的话要取出栈顶元素进行运算后入栈，/的话同理，保证栈内的元素运算级别相等
            if (tmp == '*') {
                num = stack.pop() * num;
            } else if (tmp == '/') {
                num = stack.pop() / num;
            } else if (tmp == '-') {
                num = -num;
            }
//          统一处理入栈
            stack.push(num);
        }
//        此时栈内都是运算级别相同的数字，直接求和即可，减法已经改为负数入栈
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}

