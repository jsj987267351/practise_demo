package day16;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
 * @date 2023/4/4 13:10
 * https://leetcode.cn/problems/fibonacci-number/
 */
public class demo6 {
    public int fib1(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return fib1(n-1) + fib1(n-2);
    }

    public int fib(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int[] ints = new int[n+1];
        ints[0] = 0;
        ints[1] = 1;
        for (int i = 2; i <ints.length ; i++) {
            ints[i] = ints[i-1] + ints[i-2];
        }
        return ints[n];
    }
}

