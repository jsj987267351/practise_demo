package month04.day08;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * @date 2023/4/8 15:46
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class demo1 {
    public String reverseLeftWords1(String s, int n) {
        s = reverse(s, 0, n - 1);
        s = reverse(s, n, s.length() - 1);
        s = reverse(s, 0, s.length() - 1);
        return s;
    }

    public String reverse(String s, int i, int j) {
        char[] chars = s.toCharArray();
        while (i < j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }

    public String reverseLeftWords2(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.substring(n, s.length()));
        stringBuilder.append(s.substring(0, n));
        return stringBuilder.toString();
    }
}

