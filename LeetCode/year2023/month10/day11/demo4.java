package month10.day11;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/reverse-string-ii/?envType=list&envId=RxT23Yqb
 * @date 2023/10/11 12:21
 */
public class demo4 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            reverse(chars, i, Math.min(chars.length - 1, i + k - 1));
        }
        return String.valueOf(chars);
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}

