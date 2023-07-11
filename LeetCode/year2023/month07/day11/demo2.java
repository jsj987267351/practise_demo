package month07.day11;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * <p>
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * <p>
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/7/11 13:58
 */
public class demo2 {
    public int countSubstrings1(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
//        dp[i][j]含义：在i~j区间（左右都闭区间）的字符串是否为回文字串
        boolean[][] dp = new boolean[length][length];
        int res = 0;

//        dp数组初始化全部为false,默认都不是回文字串

//        遍历顺序为从下向上，从左向右，因为从递推公式可以看出，dp[i][j]主要从dp[i + 1][j - 1]推导而来，也就是左下角
        for (int i = length - 1; i >= 0; i--) {
//            因为j一定要大于等于i下标才合理，所以j从i开始
            for (int j = i; j < length; j++) {
//                如果当前两个字符相等的话，有三种情况
                if (chars[i] == chars[j]) {
//                    第一种为两个下标指的是同一个字符，那么一定是回文子串
//                    第二种为两个下标为相邻字符，那么也一定是回文字串 例如aa
//                    两种情况用一个条件进行写
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        res++;
                    } else {
//                        第三种情况就是两个下标离得远，那么就看他们都往前一步是否是回文字串即可
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

    public int countSubstrings(String s) {
//        中心扩散法
        int res = 0;
        char[] chars = s.toCharArray();
        int length = s.length();

//       中心一共有 2 * length - 1 个，因为有可能单个字符为中心，也有可能为两个字符为中心
//        所以总共有 length  + (length -1) 个
//        遍历偶数开头，偶数结尾，所以遍历的偶数的数量比奇数多一个，但是一共是单个字符中心多一个，所以相反
        for (int center = 0; center < 2 * length - 1; center++) {
//            注意：当前下标为奇数时，代表是以2个字符（偶数）为中心的. 当前下标为偶数时，代表是以1个字符（奇数）为中心的
//            left如果当前是单个（奇数）字符的话，那么就代表当前字符的位置。如果是两个字符（偶数）的话，那么就是左边字符的位置,而且很明显遍历是二倍关系
            int left = center / 2;
//            right 如果当前是单个（奇数）字符的话，那么就代表当前字符的位置，也就是左边字符+0 。如果是两个字符（偶数）的话，那么就是右边字符的位置，也就是左边字符+1
            int right = left + center % 2;
            while (left >= 0 && right < length && chars[left] == chars[right]) {
                res++;
                left--;
                right++;
            }
        }

        return res;
    }
}

