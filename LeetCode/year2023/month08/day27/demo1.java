package month08.day27;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 *
 *https://leetcode.cn/problems/string-to-url-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/8/27 12:44
 */
public class demo1 {
    public String replaceSpaces(String S, int length) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            if (c == ' ') {
                res.append("%20");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}

