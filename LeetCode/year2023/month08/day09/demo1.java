package month08.day09;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差
 * @date 2023/8/9 16:42
 */
public class demo1 {
    public int subtractProductAndSum(int n) {
        int sum1 = 0;
        int sum2 = 1;
        while (n > 0) {
            int num = n % 10;
            n = n / 10;
            sum1 += num;
            sum2 *= num;
        }
        return sum2 - sum1;
    }
}

