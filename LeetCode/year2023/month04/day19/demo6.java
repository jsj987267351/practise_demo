package month04.day19;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * @date 2023/4/19 17:11
 */
public class demo6 {

    public int[] printNumbers(int n) {
        int[] ints = new int[(int) (1 * Math.pow(10, n)) - 1];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i + 1;
        }
        return ints;
    }

}

