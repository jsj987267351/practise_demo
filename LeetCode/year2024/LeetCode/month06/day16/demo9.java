package LeetCode.month06.day16;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/16 15:07
 */
public class demo9 {
    public int integerBreak(int n) {
       if (n == 2) return 1;
       if (n == 3) return 2;
       if (n == 4) return 4;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }
}

