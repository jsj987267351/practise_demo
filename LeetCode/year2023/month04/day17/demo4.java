package month04.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 * 链接：https://leetcode.cn/problems/power-of-two
 * @date 2023/4/17 12:40
 */
public class demo4 {
    public boolean isPowerOfTwo1(int n) {
        if (Integer.bitCount(n) != 1 || n <= 0) {
            return false;
        }
        return true;
    }


    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}

