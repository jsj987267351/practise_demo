package day2023_04_11;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 链接：https://leetcode.cn/problems/is-subsequence
 * @date 2023/4/11 17:15
 */
public class demo1 {
    public boolean isSubsequence(String s, String t) {
        if (s.length() ==0){
            return true;
        }
        if (s.length() > t.length()){
            return false;
        }
        int m = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = m; j < t.length(); j++) {
                if (t.charAt(j) == s.charAt(i)) {
                    m = j + 1;
                    break;
                }
                if (j == t.length() - 1 && t.charAt(j) != s.charAt(i)) {
                    return false;
                }
            }
            if (m == t.length() && i!= s.length()-1){
                return false;
            }
        }
        return true;
    }
}

