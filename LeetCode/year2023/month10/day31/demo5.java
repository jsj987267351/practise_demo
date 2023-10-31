package month10.day31;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/31 11:45
 */
public class demo5 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                res[i] = res[i / 2];
            } else {
                res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }
}

