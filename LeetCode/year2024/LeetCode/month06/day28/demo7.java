package LeetCode.month06.day28;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/28 10:35
 */
public class demo7 {
    public int cuttingBamboo(int bamboo_len) {
        int mod = 1000000007;
        if (bamboo_len == 2) return 1;
        if (bamboo_len == 3) return 2;
        if (bamboo_len == 4) return 4;
        long res = 1;
        while (bamboo_len > 4) {
            res = (res * 3) % mod;
            bamboo_len -= 3;
        }
        if (bamboo_len != 0) {
            res = (res * bamboo_len) % mod;
        }
        return (int) res;
    }
}

