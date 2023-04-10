package day20;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）
 * https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/
 * @date 2023/4/10 16:45
 */
public class demo2 {
    public int fib(int n) {
        int[] result = new int[101];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i < 101; i++) {

            result[i] = (result[i - 1] + result[i - 2]) % 1000000007;
        }
        return result[n];
    }
}

