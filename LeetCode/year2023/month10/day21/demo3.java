package month10.day21;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/21 12:47
 */
public class demo3 {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            int temp = x % 10;
            x = x / 10;
            res = res * 10 + temp;
        }
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;
    }
}

