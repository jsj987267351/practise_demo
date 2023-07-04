package day2023_04_18;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * 链接：https://leetcode.cn/problems/backspace-string-compare
 * @date 2023/4/18 12:44
 */
public class demo1 {
    public  boolean backspaceCompare1(String s, String t) {
        int k = -1;
        int h = -1;

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                s1.append(s.charAt(i));
                k++;
            } else {
                if (s1.length() ==0){
                    continue;
                }
                s1.deleteCharAt(k--);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != '#') {
                s2.append(t.charAt(i));
                h++;
            } else {
                if (s2.length() == 0){
                    continue;
                }
                s2.deleteCharAt(h--);
            }
        }

        return s1.toString().equals(s2.toString());
    }

    public  boolean backspaceCompare(String s, String t) {
        return reverse(s).equals(reverse(t));
    }

    public String reverse(String s){
        StringBuilder stringBuilder = new StringBuilder();
        int sum = 0;
        for (int i = s.length()-1; i >=0; i--) {
            if (s.charAt(i) == '#'){
                sum++;
            }else if (sum ==0){
                stringBuilder.append(s.charAt(i));
            }else {
                sum--;
            }
        }
        return stringBuilder.toString();
    }
}

