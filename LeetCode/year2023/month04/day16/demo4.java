package month04.day16;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * https://leetcode.cn/problems/hamming-distance/
 * @date 2023/4/16 20:14
 */
public class demo4 {
    public int hammingDistance1(int x, int y) {
        int sum = 0;
        StringBuilder sba = new StringBuilder();
        StringBuilder sbb = new StringBuilder();
        while (x != 0 || y != 0) {
            sba.append(x % 2);
            sbb.append(y % 2);
            x /= 2;
            y /= 2;
        }
        for (int i = 0; i < sba.length(); i++) {
            if (sba.charAt(i) != sbb.charAt(i)) {
                sum++;
            }
        }
        return sum;
    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }


}

