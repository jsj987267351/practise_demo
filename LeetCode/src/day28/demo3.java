package day28;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 * https://leetcode.cn/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * @date 2023/4/19 15:16
 */
public class demo3 {
    public int hammingWeight1(int n) {
        return Integer.bitCount(n);
    }

    public int hammingWeight(int n) {
        int sum = 0;
        while (n!=0){
            if ((n&1)==1){
                sum++;
            }
            n = n>>>1;
        }
        return sum;
    }
}

