package day22;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * https://leetcode.cn/problems/reverse-words-in-a-string-iii/
 * @date 2023/4/12 18:23
 */
public class demo1 {
    public String reverseWords1(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int m = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                for (int j = i-1; j >=m ; j--) {
                    stringBuilder.append(s.charAt(j));
                }
                m = i +1;
                stringBuilder.append(' ');
            }
            if (i == s.length()-1){
                for (int j = i; j >=m; j--) {
                    stringBuilder.append(s.charAt(j));
                }
                break;
            }
        }
        return stringBuilder.toString();
    }

    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] s1 = s.split(" ");
        for (String s2 : s1) {
            for (int i = s2.length()-1; i >=0 ; i--) {
                stringBuilder.append(s2.charAt(i));
            }
            stringBuilder.append(" ");
        }
        stringBuilder.setLength(stringBuilder.length()-1);
        return stringBuilder.toString();
    }
}

