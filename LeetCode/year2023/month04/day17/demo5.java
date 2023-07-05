package month04.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 * <p>
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 * 链接：https://leetcode.cn/problems/longest-palindrome
 * @date 2023/4/17 12:51
 */
public class demo5 {
    public int longestPalindrome1(String s) {
        int sum = 0;
        int[] ints = new int[53];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - 'a' >= 0 && s.charAt(i) - 'z' <= 0) {
                ints[s.charAt(i) - 'a']++;
            } else {
                ints[s.charAt(i) - 'A' + 26]++;
            }
        }
        for (int i = 0; i < 53; i++) {
            if (ints[i] % 2 != 0) {
                sum++;
                break;
            }
        }

        for (int i = 0; i < 53; i++) {
            if (ints[i] % 2 == 0) {
                sum += ints[i];
            } else {
                sum += ints[i] - 1;
            }
        }
        return sum;
    }

    public int longestPalindrome2(String s) {
        int sum = 0;
        int[] ints = new int[53];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - 'a' >= 0 && s.charAt(i) - 'z' <= 0) {
                ints[s.charAt(i) - 'a']++;
            } else {
                ints[s.charAt(i) - 'A' + 26]++;
            }
        }
        for (int i = 0; i < 53; i++) {
            sum += ints[i] / 2 * 2;
            if (ints[i] %2 ==1 && sum %2 ==0){
                sum++;
            }
        }
        return sum;
    }

    public int longestPalindrome(String s) {
        int sum = 0;
        int[] ints = new int[123];
        for (int i = 0; i < s.length(); i++) {
            ints[s.charAt(i)]++;
        }

        for (int anInt : ints) {
            sum+=anInt/2*2;
            if (anInt%2 ==1 && sum%2 ==0){
                sum++;
            }
        }
        return sum;
    }
}

