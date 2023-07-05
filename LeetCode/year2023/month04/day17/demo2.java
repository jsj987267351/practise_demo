package month04.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * https://leetcode.cn/problems/number-of-1-bits/
 * @date 2023/4/17 12:10
 */
public class demo2 {
    public int hammingWeight1(int n) {
        return Integer.bitCount(n);
    }


    public int hammingWeight(int n) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if ((n &1) !=0) {
                sum++;
            }
            n = n >>> 1;
        }
        return sum;
    }
}

