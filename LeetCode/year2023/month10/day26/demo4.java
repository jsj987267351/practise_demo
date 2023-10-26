package month10.day26;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/26 11:50
 */
public class demo4 {
    public int hammingDistance(int x, int y) {
        int sum = x ^ y;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if ((sum & 1) != 0) {
                res++;
            }
            sum >>= 1;
        }
        return res;
    }
}

