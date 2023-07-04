package day2023_04_08;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 * 链接：https://leetcode.cn/problems/palindrome-number
 * @date 2023/4/8 16:31
 */
public class demo3 {
    public boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10 && x >= 0) {
            return true;
        }
        Integer a = x;
        String s = a.toString();
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            list.add(x % 10);
            x = x / 10;
        }
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber){

            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return  x ==revertedNumber || x == revertedNumber / 10;
    }
}

