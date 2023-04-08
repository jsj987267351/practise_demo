package day18;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * @date 2023/4/7 15:20
 *https://leetcode.cn/problems/longest-common-prefix/
 */
public class demo1 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.sort(strs);
        int length = strs.length - 1;
        if ("".equals(strs[0]) || strs.length == 1) {
            return strs[0];
        }
        int length0 = strs[0].length();
        int length1 = strs[length].length();
        int small = length0 > length1 ? length1 : length0;
        int i = 0, j = 0;
        while (i<small && strs[0].charAt(i) == strs[length].charAt(j)) {
            stringBuilder.append(strs[0].charAt(i));
            i++;
            j++;
        }
        if (i == 0) {
            return new String();
        }
        return stringBuilder.toString();
    }
}

