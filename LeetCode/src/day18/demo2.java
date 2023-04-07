package day18;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * @date 2023/4/7 15:48
 */
public class demo2 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int i = 1;
        int j = x / 2;

        while (i < j) {
            int m = i + (j - i + 1) / 2;
            if (m > x / m) {
                j = m - 1;
            } else {
                i = m;
            }
        }
        return i;
    }
}

