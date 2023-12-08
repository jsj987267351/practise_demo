package month12.day07;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/7 15:03
 */
public class demo7 {
    public boolean isUgly(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }
}

