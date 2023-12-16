package month12.day16;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/16 17:35
 */
public class demo2 {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n >= 5) {
            n /= 5;
            res += n;
        }
        return res;
    }
}

