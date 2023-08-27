package month08.day27;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * https://leetcode.cn/problems/compress-string-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/8/27 13:33
 */
public class demo4 {
    public String compressString(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() == 0) {
            return s;
        }
//        代表前置元素，后面与他进行相同性比较
        char pre = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == pre) {
                count++;
            } else {
                sb.append(pre).append(count);
                pre = s.charAt(i);
                count = 1;
            }
        }
//        最后要处理一次末尾
        sb.append(pre).append(count);
        return sb.length() < s.length() ? sb.toString() : s;
    }
}

