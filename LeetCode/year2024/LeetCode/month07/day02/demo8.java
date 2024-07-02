package LeetCode.month07.day02;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/2 10:53
 */
public class demo8 {
    public int trailingZeroes(int n) {
        int res = 0;
        while (n >= 5) {
            n /= 5;
            res += n;
        }
        return res;
    }
}

