package day2023_05_29;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * <p>
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-string-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/5/29 15:26
 */
public class demo1 {
    public String reverseStr(String s, int k) {
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
//        l为翻转的头，r为翻转的尾部,l每次走2k步,注意最终r可能超过数组长度，需要取最小值
        for (int l = 0; l < length; l += 2 * k) {
            int r = l + k - 1;
            reverse(chars, l, Math.min(r, length - 1));
        }
        return String.valueOf(chars);

    }

    public void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char cl = chars[l];
            chars[l] = chars[r];
            chars[r] = cl;
            l++;
            r--;
        }
    }
}

