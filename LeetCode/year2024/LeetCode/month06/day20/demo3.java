package LeetCode.month06.day20;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/20 9:57
 */
public class demo3 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        if (n == 0) return res;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                res[i] = res[i / 2];
            } else {
                res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }
}

