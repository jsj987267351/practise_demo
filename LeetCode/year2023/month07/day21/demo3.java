package month07.day21;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/?envType=study-plan-v2&envId=coding-interviews
 * @date 2023/7/21 14:37
 */
public class demo3 {
    public double myPow(double x, int n) {
//        特判，任何数的0次方都是1
        if (n == 0) {
            return 1;
        }
//        如果是负数次幂的话，就是倒数的正数次幂
//        这里提出来一个倒数是因为测试用例中有一个 n = Integer.MIN_VALUE ,导致Integer.MIN_VALUE的相反数还是他自己,所以会一直调用，会栈溢出异常
//        所以这里提出来一个，调用里面就少一个来防止溢出
        if (n < 0) {
            return 1.0 / x * myPow(1.0 / x, -n - 1);
        }
//      如果是偶数次幂，则可以分开。例如2的4次方，其中4次方可以分为2*2次方，结合律可以为4的2次方
//      如果是奇数就需要单拿出来一个然后按偶数算，因为奇数除2是向下取整
//       最终n一定会一定会除到1，此时x即为结果，继续遍历时 myPow(x * x, n / 2) 则会返回1，所以x * myPow(x * x, n / 2) 就会返回x，也就是答案
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}

