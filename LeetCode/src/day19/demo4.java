package day19;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 *
 * 字母和数字都属于字母数字字符。）
 * 链接：https://leetcode.cn/problems/valid-palindrome

 * @date 2023/4/8 17:17
 */
public class demo4 {
    public boolean isPalindrome(String s) {
         s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i< s.length()){
            if (s.charAt(i)>='a' && s.charAt(i) <= 'z' ||(s.charAt(i)>= '0' && s.charAt(i)<='9')){
                sb.append(s.charAt(i));
            }
            i++;
        }
        s = sb.toString();
        int start = 0;
        int end = s.length()-1;
        while (start <end){
            if (s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

