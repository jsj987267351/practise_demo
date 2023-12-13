package month12.day13;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/13 13:53
 */
public class demo3 {
    private final int Mod = 1000000007;

    public int cuttingBamboo(int bamboo_len) {
        if (bamboo_len < 4) {
            return bamboo_len - 1;
        }
//        结果要用long类型接收，不然溢出int
        long res = 1;
        while (bamboo_len > 4) {
            res *= 3;
            res %= Mod;
            bamboo_len -= 3;
        }
        return (int)(res * bamboo_len % Mod);
    }
}

