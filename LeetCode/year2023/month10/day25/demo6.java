package month10.day25;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/25 16:48
 */
public class demo6 {
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) != 0) {
                res++;
            }
            n >>= 1;
        }
        return res;
    }
}

