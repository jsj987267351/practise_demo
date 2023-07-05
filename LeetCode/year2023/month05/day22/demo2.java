package month05.day22;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * @date 2023/5/22 17:23
 */
public class demo2 {
    public String reverseWords1(String s) {
        s = " " + s;
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (temp.length() > 0) {
                    result.append(temp.reverse().toString()).append(' ');
                    temp = temp.delete(0, temp.length());
                }
            } else {
                temp.append(s.charAt(i));
            }
        }
        return result.toString().trim();
    }

    public static String reverseWords(String s) {
        String[] s1 = s.trim().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].equals("")) continue;
            result.append(s1[i]).append(" ");
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String a = "a good   example";
        String s = reverseWords(a);
    }
}

