package day25;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案
 * https://leetcode.cn/problems/counting-bits/
 * @date 2023/4/16 19:23
 */
public class demo1 {
    public int[] countBits1(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            result[i] = Two(i);
        }
        return result;
    }

    private int Two(int i) {
        int sum = 0;
        while (i != 0) {
            if (i % 2 == 1) {
                sum++;
            }
            i = i / 2;
        }
        return sum;
    }



    /***
    * @description 奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
     * 偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
    * @param n
    * @return int[]
    * @author 大爆炸
    * @date 2023/4/16 19:53
    */

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            if (i%2 ==0){
                result[i] = result[i/2];
            }else {
                result[i] = result[i-1] + 1;
            }
        }
        return result;
    }


}

