package day33;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 链接：https://leetcode.cn/problems/reverse-integer
 * @date 2023/5/4 15:54
 */
public class demo3 {
    public int reverse1(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            swap(chars, i, j);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int k = 0; k < chars.length; k++) {
            stringBuilder.append(chars[k]);
        }
        int result = Integer.parseInt(String.valueOf(stringBuilder));
        if (x < 0) {
            result = result - 2 * result;
        }
        return result;
    }

    private void swap(char[] chars, int i, int j) {
        char aChar = chars[i];
        chars[i] = chars[j];
        chars[j] = aChar;
    }


    public int reverse2(int x) {
        boolean flag = true;
        if (x < 0) {
            flag = false;
            x = Math.abs(x);
        }
        String s = String.valueOf(x);
        int length = s.length() - 1;
        long sum = 0;
        while (x != 0) {
            sum += x % 10 * Math.pow(10, length);
            x /= 10;
            length--;
        }
        if (!flag) {
            sum = sum - 2 * sum;
        }
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) sum;
    }

    public int reverse(int x) {
        long sum = 0;
        while (x != 0) {
            sum = sum * 10 + x % 10;
            x /= 10;
        }
        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) sum;
    }

}

