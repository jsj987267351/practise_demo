package month05.day05;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string
 * @date 2023/5/5 20:22
 */
public class demo3 {
    public int strStr1(String haystack, String needle) {

        if (needle.length() > haystack.length()) {
            return -1;
        }

        boolean flag = true;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.length() - i < needle.length()) {
                    return -1;
                }
                int k = i;
                for (int j = 0; j < needle.length(); j++, k++) {
                    if (haystack.charAt(k) != needle.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
                flag = true;
            }
        }
        return -1;
    }

    public int strStr(String ss, String pp) {
        int m = ss.length(), n = pp.length();

        for (int i = 0; i <= m - n; i++) {
            int a = i;
            int b = 0;
            while (b < n && ss.charAt(a)==pp.charAt(b)) {
                a++;
                b++;
            }
            if (b == n) return i;
        }
        return -1;
    }
}

