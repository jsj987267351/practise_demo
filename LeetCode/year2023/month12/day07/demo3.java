package month12.day07;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/7 13:58
 */
public class demo3 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1.0 / x * myPow(1.0 / x, -n - 1);
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}

