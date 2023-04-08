package day14;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * @date 2023/4/1 19:18
 * https://leetcode.cn/problems/plus-one/
 */
public class demo1 {
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >=0 ; i--) {
            if (digits[i] ==9){
                digits[i] = 0;
            }else {
                digits[i]+=1;
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}

